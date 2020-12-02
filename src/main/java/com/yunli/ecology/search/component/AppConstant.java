package com.yunli.ecology.search.component;

import com.yunli.ecology.search.enums.SearchEnum;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author wangyue
 * @date 2020/11/25 11:01 AM
 */
public class AppConstant {

    public static final Map<SearchEnum, String> INIT_SEARCH_DESC = new TreeMap<>();

    static {
        INIT_SEARCH_DESC.put(SearchEnum.PP, "某雨量站情况");
        INIT_SEARCH_DESC.put(SearchEnum.ZQ, "某河道水情站情况");
        INIT_SEARCH_DESC.put(SearchEnum.RR, "某水库水情站情况");
        INIT_SEARCH_DESC.put(SearchEnum.SS, "某土壤墒情站情况");
        INIT_SEARCH_DESC.put(SearchEnum.WCP, "某水利工程情况");
        INIT_SEARCH_DESC.put(SearchEnum.CS, "联系人详情");
        INIT_SEARCH_DESC.put(SearchEnum.RC, "河长情况");
    }

    public static final String STR_ATTRIBUTE = "attribute";

    public static final String SEARCH_NAME_KEYWORD = "name.keyword";
    public static final String SEARCH_NAME_PINYIN = "name.pinyin";
    public static final String SEARCH_NAME_SUGGEST = "name.suggest";
    public static final String SEARCH_NAME_SUGGEST_PINYIN = "name.suggest_pinyin";

    public static final String DATE_FORMAT_PATTERN = "MM月dd日";
    public static final String DATE_FORMAT_PATTERN2 = "MM月dd日HH:mm";

    public static final String DO_NOT_HAVE_IOT_DATA = "暂无监测数据";

}
