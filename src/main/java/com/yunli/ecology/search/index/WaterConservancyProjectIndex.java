package com.yunli.ecology.search.index;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Mapping;
import org.springframework.data.elasticsearch.annotations.Setting;

/**
 * 水利工程
 *
 * @author wangyue
 * @date 2020/11/21 5:33 PM
 */
@Data
@Setting(settingPath = "/es/setting/default.json")
@Mapping(mappingPath = "/es/mapping/waterConservancyProject.json")
@Document(indexName = "water_conservancy_project")
public class WaterConservancyProjectIndex {

    /**
     *
     */
    @Id
    private String id;
    /**
     * 数据中台表的主键
     */
    private String tableId;
    /**
     * 名称
     */
    private String name;
    /**
     * 因为数据有可能有错,所以不使用geo_point
     */
    private Double longitude;
    /**
     *
     */
    private Double latitude;
    /**
     * 图层id
     */
    private String layerId;
    /**
     * 数据类型
     *
     * @see com.yunli.ecology.search.enums.DataTypeEnum
     */
    private String dataType;

    private String dataTypeDesc;
    /**
     * 属性List<Attribute>
     */
    private String attribute;

}
