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
@JobHandler(value = "waterConservancyProjectGateJob")
public class WaterConservancyProjectGateJob extends IJobHandler {

    @Autowired
    private MidDataService midDataService;
    @Autowired
    private WaterConservancyProjectIndexRepository waterConservancyProjectIndexRepository;

    @Override
    public ReturnT<String> execute(String s) {
        if (log.isInfoEnabled()) {
            log.info("waterConservancyProjectGATEJob开始执行");
        }
        // 查询中台
        QueryDataReq queryDataReq = new QueryDataReq();
        queryDataReq.setTableName("adm_zhslyzt_gate");
        // 查询数据
        List<Map<String, Object>> data = midDataService.queryData(queryDataReq).isOk();
        if (log.isInfoEnabled()) {
            log.info("waterConservancyProjectGATEJob查询出总数据量:{}", data.size());
        }
        // 写入es
        if (!CollectionUtils.isEmpty(data)) {
            List<WaterConservancyProjectIndex> collect = midDataService.queryData(queryDataReq).isOk().stream().map(stringObjectMap -> {
                WaterConservancyProjectIndex waterConservancyProjectIndex = new WaterConservancyProjectIndex();
                waterConservancyProjectIndex.setId(WaterConservancyProjectTypeEnum.GATE.name() + Objects.toString(stringObjectMap.get("gate_code"), "").trim());
                waterConservancyProjectIndex.setTableId(Objects.toString(stringObjectMap.get("gate_code"), "").trim());
                waterConservancyProjectIndex.setName(Objects.toString(stringObjectMap.get("gate_name"), "").trim());
                waterConservancyProjectIndex.setDataType(DataTypeEnum.GATE.name());
                waterConservancyProjectIndex.setDataTypeDesc(DataTypeEnum.GATE.getDesc());
                waterConservancyProjectIndex.setLongitude(Double.parseDouble(Objects.toString(stringObjectMap.get("gate_long"), "0").trim()));
                waterConservancyProjectIndex.setLatitude(Double.parseDouble(Objects.toString(stringObjectMap.get("gate_lat"), "0").trim()));
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
                    attribute.setItem("gate_res_code");
                    attribute.setItemName("所属水库编码");
                    attribute.setValue(stringObjectMap.get("gate_res_code"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("gate_long");
                    attribute.setItemName("经度");
                    attribute.setValue(stringObjectMap.get("gate_long"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("gate_lat");
                    attribute.setItemName("纬度");
                    attribute.setValue(stringObjectMap.get("gate_lat"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("gate_loc");
                    attribute.setItemName("位置");
                    attribute.setValue(stringObjectMap.get("gate_loc"));
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
                    attribute.setItem("proj_scal");
                    attribute.setItemName("工程规模");
                    attribute.setValue(stringObjectMap.get("proj_scal"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("main_build_grad");
                    attribute.setItemName("主要建筑物级别");
                    attribute.setValue(stringObjectMap.get("main_build_grad"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("waga_type");
                    attribute.setItemName("水闸类型");
                    attribute.setValue(stringObjectMap.get("waga_type"));
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
                    attribute.setItem("des_gate_q");
                    attribute.setItemName("过闸流量");
                    attribute.setValue(stringObjectMap.get("des_gate_q"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("gate_hole_num");
                    attribute.setItemName("闸孔数量");
                    attribute.setValue(stringObjectMap.get("gate_hole_num"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("gate_tw");
                    attribute.setItemName("闸孔总净宽");
                    attribute.setValue(stringObjectMap.get("gate_tw"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("design_flood");
                    attribute.setItemName("设计洪水标准");
                    attribute.setValue(stringObjectMap.get("design_flood"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("check_flood");
                    attribute.setItemName("校核洪水标准");
                    attribute.setValue(stringObjectMap.get("check_flood"));
                    attributeList.add(attribute);
                }
                waterConservancyProjectIndex.setAttribute(JSON.toJSONString(attributeList));
                return waterConservancyProjectIndex;
            }).collect(Collectors.toList());
            try {
                waterConservancyProjectIndexRepository.saveAll(collect);
                if (log.isInfoEnabled()) {
                    log.info("waterConservancyProjectGATEJob执行完成:{}", collect.size());
                }
            } catch (Exception e) {
                log.error("waterConservancyProjectGATEJob插入数据错误", e);
            }
        }
        return SUCCESS;
    }
}
