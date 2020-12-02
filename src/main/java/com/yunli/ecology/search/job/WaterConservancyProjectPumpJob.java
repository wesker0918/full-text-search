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
@JobHandler(value = "waterConservancyProjectPumpJob")
public class WaterConservancyProjectPumpJob extends IJobHandler {

    @Autowired
    private MidDataService midDataService;
    @Autowired
    private WaterConservancyProjectIndexRepository waterConservancyProjectIndexRepository;

    @Override
    public ReturnT<String> execute(String s) {
        if (log.isInfoEnabled()) {
            log.info("waterConservancyProjectPumpJob开始执行");
        }
        // 查询中台
        QueryDataReq queryDataReq = new QueryDataReq();
        queryDataReq.setTableName("adm_zhslyzt_pump");
        // 查询数据
        List<Map<String, Object>> data = midDataService.queryData(queryDataReq).isOk();
        if (log.isInfoEnabled()) {
            log.info("waterConservancyProjectPumpJob查询出总数据量:{}", data.size());
        }
        // 写入es
        if (!CollectionUtils.isEmpty(data)) {
            List<WaterConservancyProjectIndex> collect = midDataService.queryData(queryDataReq).isOk().stream().map(stringObjectMap -> {
                WaterConservancyProjectIndex waterConservancyProjectIndex = new WaterConservancyProjectIndex();
                waterConservancyProjectIndex.setId(WaterConservancyProjectTypeEnum.PUMP.name() + Objects.toString(stringObjectMap.get("pust_code"), "").trim());
                waterConservancyProjectIndex.setTableId(Objects.toString(stringObjectMap.get("pust_code"), "").trim());
                waterConservancyProjectIndex.setName(Objects.toString(stringObjectMap.get("pust_name"), "").trim());
                waterConservancyProjectIndex.setDataType(DataTypeEnum.PUMP.name());
                waterConservancyProjectIndex.setDataTypeDesc(DataTypeEnum.PUMP.getDesc());
                waterConservancyProjectIndex.setLongitude(Double.parseDouble(Objects.toString(stringObjectMap.get("pust_long"), "0").trim()));
                waterConservancyProjectIndex.setLatitude(Double.parseDouble(Objects.toString(stringObjectMap.get("pust_lat"), "0").trim()));
                // attribute
                List<Attribute> attributeList = new ArrayList<>();
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
                    attribute.setItem("area_code");
                    attribute.setItemName("行政区划code");
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
                    attribute.setItem("pump_res_code");
                    attribute.setItemName("所属水库编码");
                    attribute.setValue(stringObjectMap.get("pump_res_code"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("pump_gate_code");
                    attribute.setItemName("所属水闸编码");
                    attribute.setValue(stringObjectMap.get("pump_gate_code"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("pump_dike_code");
                    attribute.setItemName("所属堤防编码");
                    attribute.setValue(stringObjectMap.get("pump_dike_code"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("pust_long");
                    attribute.setItemName("经度");
                    attribute.setValue(stringObjectMap.get("pust_long"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("pust_lat");
                    attribute.setItemName("纬度");
                    attribute.setValue(stringObjectMap.get("pust_lat"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("pust_loc");
                    attribute.setItemName("位置");
                    attribute.setValue(stringObjectMap.get("pust_loc"));
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
                    attribute.setItem("eng_grad");
                    attribute.setItemName("工程等别");
                    attribute.setValue(stringObjectMap.get("eng_grad"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("pust_type");
                    attribute.setItemName("泵站类型");
                    attribute.setValue(stringObjectMap.get("pust_type"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("eng_task");
                    attribute.setItemName("工程任务");
                    attribute.setValue(stringObjectMap.get("eng_task"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("ins_flow");
                    attribute.setItemName("装机流量");
                    attribute.setValue(stringObjectMap.get("ins_flow"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("ins_pow");
                    attribute.setItemName("装机功率");
                    attribute.setValue(stringObjectMap.get("ins_pow"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("des_head");
                    attribute.setItemName("设计扬程");
                    attribute.setValue(stringObjectMap.get("des_head"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("pump_num");
                    attribute.setItemName("水泵数量");
                    attribute.setValue(stringObjectMap.get("pump_num"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("unit_name");
                    attribute.setItemName("管理单位");
                    attribute.setValue(stringObjectMap.get("unit_name"));
                    attributeList.add(attribute);
                }
                waterConservancyProjectIndex.setAttribute(JSON.toJSONString(attributeList));
                return waterConservancyProjectIndex;
            }).collect(Collectors.toList());
            try {
                waterConservancyProjectIndexRepository.saveAll(collect);
                if (log.isInfoEnabled()) {
                    log.info("waterConservancyProjectPumpJob执行完成:{}", collect.size());
                }
            } catch (Exception e) {
                log.error("waterConservancyProjectPumpJob插入数据错误", e);
            }
        }
        return SUCCESS;
    }
}
