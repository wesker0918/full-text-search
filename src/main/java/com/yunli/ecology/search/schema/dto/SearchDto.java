package com.yunli.ecology.search.schema.dto;

import com.yunli.ecology.search.schema.bo.Attribute;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangyue
 * @date 2020/11/25 5:36 PM
 */
@Data
public class SearchDto {

    private String id;
    private String tableId;
    private String name;
    private Double longitude;
    private Double latitude;
    private String provRegionName;
    private String cityRegionName;
    private String districtRegionName;
    private String layerId;
    private List<Attribute> attributes = new ArrayList<>();
    private String dataType;
    private String dataTypeDesc;
    private String iotData;

}
