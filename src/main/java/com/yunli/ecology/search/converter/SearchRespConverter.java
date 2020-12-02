package com.yunli.ecology.search.converter;

import com.yunli.ecology.search.schema.dto.SearchDto;
import com.yunli.ecology.search.schema.response.SearchResp;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author wangyue
 * @date 2020/11/25 5:39 PM
 */
@Mapper(componentModel = "spring")
public interface SearchRespConverter {

    /**
     * @param searchDto
     * @return
     */
    SearchResp convert2SearchResp(SearchDto searchDto);

    /**
     * @param searchDtoList
     * @return
     */
    List<SearchResp> convert2SearchResp(List<SearchDto> searchDtoList);

}
