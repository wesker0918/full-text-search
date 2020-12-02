package com.yunli.ecology.search.index;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Mapping;
import org.springframework.data.elasticsearch.annotations.Setting;

/**
 * @author wangyue
 * @date 2020/11/21 5:33 PM
 */
@Data
@Setting(settingPath = "/es/setting/default.json")
@Mapping(mappingPath = "/es/mapping/monitoringStationMapping.json")
@Document(indexName = "contacts")
public class ContactsIndex {
}
