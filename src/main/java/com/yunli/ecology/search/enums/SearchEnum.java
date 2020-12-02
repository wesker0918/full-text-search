package com.yunli.ecology.search.enums;

/**
 * 检索条件
 *
 * @author wangyue
 * @date 2020/11/21 4:16 PM
 */
public enum SearchEnum {

    /**
     * 雨量站
     */
    PP("rainfall_station"),
    /**
     * 河道水情站
     */
    ZQ("hydrological_station"),
    /**
     * 水库水情站
     */
    RR("reservoir_hydrological_station"),
    /**
     * 土壤墒情站
     */
    SS("soil_moisture_station"),
    /**
     * 水利工程
     */
    WCP("water_conservancy_project"),
    /**
     * 联系人
     */
    CS("contacts"),
    /**
     * 河长
     */
    RC("river_chief"),
    ;

    /**
     * 索引名称
     */
    private String indexName;

    SearchEnum(String indexName) {
        this.indexName = indexName;
    }

    public String getIndexName() {
        return indexName;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }
}
