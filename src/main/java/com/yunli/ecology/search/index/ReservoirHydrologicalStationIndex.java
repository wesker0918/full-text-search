package com.yunli.ecology.search.index;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Mapping;
import org.springframework.data.elasticsearch.annotations.Setting;

/**
 * 水库水情站
 *
 * @author wangyue
 * @date 2020/11/21 5:32 PM
 */
@Data
@Setting(settingPath = "/es/setting/default.json")
@Mapping(mappingPath = "/es/mapping/monitoringStationMapping.json")
@Document(indexName = "reservoir_hydrological_station")
public class ReservoirHydrologicalStationIndex {

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
     * 测站名称
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
     * 省级行政区划名称
     */
    private String provRegionName;
    /**
     * 市级行政区划名称
     */
    private String cityRegionName;
    /**
     * 区县级行政区划名称
     */
    private String districtRegionName;
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

}
