package com.yunli.ecology.search.job;

import com.alibaba.fastjson.JSON;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.yunli.ecology.search.enums.DataTypeEnum;
import com.yunli.ecology.search.enums.WaterConservancyProjectTypeEnum;
import com.yunli.ecology.search.index.WaterConservancyProjectIndex;
import com.yunli.ecology.search.remote.MidDataService;
import com.yunli.ecology.search.remote.request.QueryDataReq;
import com.yunli.ecology.search.repository.es.WaterConservancyProjectIndexRepository;
import com.yunli.ecology.search.schema.bo.Attribute;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author wangyue
 * @date 2020/11/25 7:05 PM
 */
@Slf4j
@Component
@JobHandler(value = "waterConservancyProjectResJob")
public class WaterConservancyProjectResJob extends IJobHandler {

    @Autowired
    private MidDataService midDataService;
    @Autowired
    private WaterConservancyProjectIndexRepository waterConservancyProjectIndexRepository;

    @Override
    public ReturnT<String> execute(String s) {
        if (log.isInfoEnabled()) {
            log.info("waterConservancyProjectRESJob开始执行");
        }
        // 查询中台
        QueryDataReq queryDataReq = new QueryDataReq();
        queryDataReq.setTableName("adm_zhslyzt_res");
        // 查询数据
        List<Map<String, Object>> data = midDataService.queryData(queryDataReq).isOk();
        if (log.isInfoEnabled()) {
            log.info("waterConservancyProjectRESJob查询出总数据量:{}", data.size());
        }
        // 写入es
        if (!CollectionUtils.isEmpty(data)) {
            List<WaterConservancyProjectIndex> collect = midDataService.queryData(queryDataReq).isOk().stream().map(stringObjectMap -> {
                WaterConservancyProjectIndex waterConservancyProjectIndex = new WaterConservancyProjectIndex();
                waterConservancyProjectIndex.setId(WaterConservancyProjectTypeEnum.RES.name() + Objects.toString(stringObjectMap.get("res_code"), "").trim());
                waterConservancyProjectIndex.setTableId(Objects.toString(stringObjectMap.get("res_code"), "").trim());
                waterConservancyProjectIndex.setName(Objects.toString(stringObjectMap.get("res_name"), "").trim());
                waterConservancyProjectIndex.setDataType(DataTypeEnum.RES.name());
                waterConservancyProjectIndex.setDataTypeDesc(DataTypeEnum.RES.getDesc());
                waterConservancyProjectIndex.setLongitude(Double.parseDouble(Objects.toString(stringObjectMap.get("res_long"), "0").trim()));
                waterConservancyProjectIndex.setLatitude(Double.parseDouble(Objects.toString(stringObjectMap.get("res_lat"), "0").trim()));
                // attribute
                List<Attribute> attributeList = new ArrayList<>();
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("area_code");
                    attribute.setItemName("行政区划编码");
                    attribute.setValue(stringObjectMap.get("area_code"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("area_name");
                    attribute.setItemName("行政区划名称");
                    attribute.setValue(stringObjectMap.get("area_name"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("rv_code");
                    attribute.setItemName("所属河流编码");
                    attribute.setValue(stringObjectMap.get("rv_code"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("rv_name");
                    attribute.setItemName("所属河流名称");
                    attribute.setValue(stringObjectMap.get("rv_name"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("lk_code");
                    attribute.setItemName("所属湖泊编码");
                    attribute.setValue(stringObjectMap.get("lk_code"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("lk_name");
                    attribute.setItemName("所属湖泊编码");
                    attribute.setValue(stringObjectMap.get("lk_name"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("bas_code");
                    attribute.setItemName("所属流域编码");
                    attribute.setValue(stringObjectMap.get("bas_code"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("bas_name");
                    attribute.setItemName("所属流域名称");
                    attribute.setValue(stringObjectMap.get("bas_name"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("res_long");
                    attribute.setItemName("经度");
                    attribute.setValue(stringObjectMap.get("res_long"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("res_lat");
                    attribute.setItemName("纬度");
                    attribute.setValue(stringObjectMap.get("res_lat"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("res_loc");
                    attribute.setItemName("所在位置");
                    attribute.setValue(stringObjectMap.get("res_loc"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("comp_date");
                    attribute.setItemName("建成时间");
                    attribute.setValue(stringObjectMap.get("comp_date"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("eng_scal");
                    attribute.setItemName("工程规模");
                    attribute.setValue(stringObjectMap.get("eng_scal"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("unit_name");
                    attribute.setItemName("管理单位");
                    attribute.setValue(stringObjectMap.get("unit_name"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("tot_cap");
                    attribute.setItemName("总库容");
                    attribute.setValue(stringObjectMap.get("tot_cap"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("ben_res_cap");
                    attribute.setItemName("兴利库容");
                    attribute.setValue(stringObjectMap.get("ben_res_cap"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("flco_cap");
                    attribute.setItemName("防洪库容");
                    attribute.setValue(stringObjectMap.get("flco_cap"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("dead_cap");
                    attribute.setItemName("死库容");
                    attribute.setValue(stringObjectMap.get("dead_cap"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("check_level");
                    attribute.setItemName("校核洪水位");
                    attribute.setValue(stringObjectMap.get("check_level"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("design_level");
                    attribute.setItemName("设计洪水位");
                    attribute.setValue(stringObjectMap.get("design_level"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("normal_level");
                    attribute.setItemName("正常高水位");
                    attribute.setValue(stringObjectMap.get("normal_level"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("dead_lev");
                    attribute.setItemName("死水位");
                    attribute.setValue(stringObjectMap.get("dead_lev"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("usable_level");
                    attribute.setItemName("兴利水位");
                    attribute.setValue(stringObjectMap.get("usable_level"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("flood_control_level");
                    attribute.setItemName("汛期水位");
                    attribute.setValue(stringObjectMap.get("flood_control_level"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("highest_level");
                    attribute.setItemName("历史极值-最高库水位");
                    attribute.setValue(stringObjectMap.get("highest_level"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("highest_storage");
                    attribute.setItemName("历史极值-最大蓄水量");
                    attribute.setValue(stringObjectMap.get("highest_storage"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("highest_time");
                    attribute.setItemName("历史极值-最高库水位(蓄水量)出现时间");
                    attribute.setValue(stringObjectMap.get("highest_time"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("lowest_level");
                    attribute.setItemName("历史极值-最低库水位");
                    attribute.setValue(stringObjectMap.get("lowest_level"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("lowest_level_time");
                    attribute.setItemName("历史极值-最低库水位出现时间");
                    attribute.setValue(stringObjectMap.get("lowest_level_time"));
                    attributeList.add(attribute);
                }
                waterConservancyProjectIndex.setAttribute(JSON.toJSONString(attributeList));
                return waterConservancyProjectIndex;
            }).collect(Collectors.toList());
            try {
                waterConservancyProjectIndexRepository.saveAll(collect);
                if (log.isInfoEnabled()) {
                    log.info("waterConservancyProjectRESJob执行完成:{}", collect.size());
                }
            } catch (Exception e) {
                log.error("waterConservancyProjectRESJob插入数据错误", e);
            }
        }
        return SUCCESS;
    }
}
