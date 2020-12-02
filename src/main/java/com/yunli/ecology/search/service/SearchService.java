package com.yunli.ecology.search.service;

import com.alibaba.fastjson.JSONArray;
import com.yunli.ecology.search.component.AppConstant;
import com.yunli.ecology.search.converter.SearchRespConverter;
import com.yunli.ecology.search.enums.SceneEnum;
import com.yunli.ecology.search.enums.SearchEnum;
import com.yunli.ecology.search.properties.FtsProperties;
import com.yunli.ecology.search.schema.bo.Attribute;
import com.yunli.ecology.search.schema.dto.SearchDto;
import com.yunli.ecology.search.schema.request.SearchReq;
import com.yunli.ecology.search.schema.request.SuggestReq;
import com.yunli.ecology.search.schema.response.SearchInitResp;
import com.yunli.ecology.search.schema.response.SearchResp;
import com.yunli.smart.ecology.tools.ChineseUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.suggest.SuggestBuilder;
import org.elasticsearch.search.suggest.completion.CompletionSuggestionBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author wangyue
 * @date 2020/11/25 10:44 AM
 */
@Slf4j
@Service
public class SearchService {

    @Autowired
    private FtsProperties ftsProperties;
    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;
    @Resource
    private SearchRespConverter searchRespConverter;
    @Resource
    private Map<String, IotService> iotServiceMap;

    private final String iotServiceBeanPrefix = "iotService#";

    /**
     * 水娃显示查询页
     *
     * @return
     */
    public List<SearchInitResp> init() {
        List<SearchInitResp> list = new ArrayList<>();
        AppConstant.INIT_SEARCH_DESC.forEach((searchEnum, s) -> {
            SearchInitResp searchInitResp = new SearchInitResp();
            searchInitResp.setSearchKey(searchEnum.name());
            searchInitResp.setDesc(s);
            list.add(searchInitResp);
        });
        return list;
    }

    /**
     * @param searchReq
     * @return
     */
    public List<SearchResp> search(SearchReq searchReq) {
        Set<SearchDto> searchDtoSet = new HashSet<>();
        List<SearchEnum> searchAllEnums = ftsProperties.getScene().get(searchReq.getScene());
        // 确定索引
        String searchIndices = null == searchReq.getSearchKey() ? searchAllEnums.stream().map(SearchEnum::getIndexName).collect(Collectors.joining(",")) : searchReq.getSearchKey().getIndexName();
        // 搜索内容是否有中文或字母
        // 1. 中文按name.keyword使用wildcard进行搜索
        String chinese = ChineseUtil.filterNotChinese(searchReq.getContent());
        if (!StringUtils.isEmpty(chinese)) {
            searchDtoSet.addAll(searchWithChinese(searchIndices, chinese));
        }
        // 2. 英文按name.pinyin进行搜索
        String english = ChineseUtil.filterChinese(searchReq.getContent());
        if (!StringUtils.isEmpty(english)) {
            searchDtoSet.addAll(searchWithEnglish(searchIndices, english));
        }
        List<SearchDto> searchDtoList = new ArrayList<>(searchDtoSet);
        // 查询测站
        if (searchReq.getScene().equals(SceneEnum.ROBOT) && !CollectionUtils.isEmpty(searchDtoList)) {
            searchDtoList.forEach(searchDto -> {
                IotService iotService = iotServiceMap.get(iotServiceBeanPrefix.concat(searchDto.getDataType()));
                // 没有的不查询
                if (!Objects.isNull(iotService)) {
                    searchDto.setIotData(iotService.queryIotData(searchDto.getTableId()));
                }
            });
        }
        return searchRespConverter.convert2SearchResp(searchDtoList);
    }

    /**
     * @param searchIndices
     * @param content
     * @return
     */
    private List<SearchDto> searchWithChinese(String searchIndices, String content) {
        return elasticsearchRestTemplate.query(new NativeSearchQueryBuilder().withIndices(searchIndices).withQuery(QueryBuilders.wildcardQuery(AppConstant.SEARCH_NAME_KEYWORD, "*" + content + "*")).build(), response -> {
            return Arrays.stream(response.getHits().getHits()).map(documentFields -> {
                SearchDto searchDto = new SearchDto();
                Map<String, Object> sourceAsMap = documentFields.getSourceAsMap();
                try {
                    BeanUtils.populate(searchDto, sourceAsMap);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
                if (sourceAsMap.containsKey(AppConstant.STR_ATTRIBUTE)) {
                    List<Attribute> attributeList = JSONArray.parseArray(sourceAsMap.get(AppConstant.STR_ATTRIBUTE).toString(), Attribute.class);
                    searchDto.setAttributes(attributeList);
                }
                return searchDto;
            }).collect(Collectors.toList());
        });
    }

    /**
     * @param searchIndices
     * @param content
     * @return
     */
    private List<SearchDto> searchWithEnglish(String searchIndices, String content) {
        return elasticsearchRestTemplate.query(new NativeSearchQueryBuilder().withIndices(searchIndices).withQuery(QueryBuilders.termQuery(AppConstant.SEARCH_NAME_PINYIN, content)).build(), response -> {
            return Arrays.stream(response.getHits().getHits()).map(documentFields -> {
                SearchDto searchDto = new SearchDto();
                Map<String, Object> sourceAsMap = documentFields.getSourceAsMap();
                try {
                    BeanUtils.populate(searchDto, sourceAsMap);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
                if (sourceAsMap.containsKey(AppConstant.STR_ATTRIBUTE)) {
                    List<Attribute> attributeList = JSONArray.parseArray(sourceAsMap.get(AppConstant.STR_ATTRIBUTE).toString(), Attribute.class);
                    searchDto.setAttributes(attributeList);
                }
                return searchDto;
            }).collect(Collectors.toList());
        });
    }

    public Set<String> suggest(SuggestReq suggestReq) {
        Set<String> result = new HashSet<>();
        //
        List<SearchEnum> searchEnums = ftsProperties.getScene().get(SceneEnum.LAYER);
        String searchIndices = searchEnums.stream().map(SearchEnum::getIndexName).collect(Collectors.joining(","));

        SuggestBuilder suggestBuilder = new SuggestBuilder();
        // 搜索内容是否有中文或字母
        // 1. 中文按name.suggest进行搜索
        String chinese = ChineseUtil.filterNotChinese(suggestReq.getContent());
        if (!StringUtils.isEmpty(chinese)) {
            CompletionSuggestionBuilder suggestionBuilderDistrict = new CompletionSuggestionBuilder(AppConstant.SEARCH_NAME_SUGGEST).prefix(chinese).size(10);
            suggestBuilder.addSuggestion(AppConstant.SEARCH_NAME_SUGGEST, suggestionBuilderDistrict);
        }
        // 2. 英文按name.suggest_pinyin进行搜索
        String english = ChineseUtil.filterChinese(suggestReq.getContent());
        if (!StringUtils.isEmpty(english)) {
            CompletionSuggestionBuilder suggestionBuilderDistrictEnglish = new CompletionSuggestionBuilder(AppConstant.SEARCH_NAME_SUGGEST_PINYIN).prefix(english).size(10);
            suggestBuilder.addSuggestion(AppConstant.SEARCH_NAME_SUGGEST_PINYIN, suggestionBuilderDistrictEnglish);
        }
        //
        elasticsearchRestTemplate.suggest(suggestBuilder, searchIndices).getSuggest().forEach(entries -> {
            entries.getEntries().forEach(options -> {
                options.getOptions().forEach(option -> {
                    result.add(option.getText().string());
                });
            });
        });
        return result;
    }

}
