package com.yunli.ecology.search.schema.response;

import com.google.common.hash.HashCode;
import com.yunli.ecology.search.schema.bo.Attribute;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangyue
 * @date 2020/11/25 5:09 PM
 */
@Data
public class SearchResp {

    /**
     *
     */
    private String id;
    /**
     *
     */
    private String tableId;
    /**
     *
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
     */
    private String dataType;
    /**
     * 数据类型
     */
    private String dataTypeDesc;
    /**
     *
     */
    private List<Attribute> attributes = new ArrayList<>();
    /**
     * 测站监测数据
     */
    private String iotData;

}
