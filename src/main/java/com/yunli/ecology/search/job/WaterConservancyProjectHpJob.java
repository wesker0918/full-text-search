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
@JobHandler(value = "waterConservancyProjectHpJob")
public class WaterConservancyProjectHpJob extends IJobHandler {

    @Autowired
    private MidDataService midDataService;
    @Autowired
    private WaterConservancyProjectIndexRepository waterConservancyProjectIndexRepository;

    @Override
    public ReturnT<String> execute(String s) {
        if (log.isInfoEnabled()) {
            log.info("waterConservancyProjectHPJob开始执行");
        }
        // 查询中台
        QueryDataReq queryDataReq = new QueryDataReq();
        queryDataReq.setTableName("adm_zhslyzt_hp");
        // 查询数据
        List<Map<String, Object>> data = midDataService.queryData(queryDataReq).isOk();
        if (log.isInfoEnabled()) {
            log.info("waterConservancyProjectHPJob查询出总数据量:{}", data.size());
        }
        // 写入es
        if (!CollectionUtils.isEmpty(data)) {
            List<WaterConservancyProjectIndex> collect = midDataService.queryData(queryDataReq).isOk().stream().map(stringObjectMap -> {
                WaterConservancyProjectIndex waterConservancyProjectIndex = new WaterConservancyProjectIndex();
                waterConservancyProjectIndex.setId(WaterConservancyProjectTypeEnum.HP.name() + Objects.toString(stringObjectMap.get("hyst_code"), "").trim());
                waterConservancyProjectIndex.setTableId(Objects.toString(stringObjectMap.get("hyst_code"), "").trim());
                waterConservancyProjectIndex.setName(Objects.toString(stringObjectMap.get("hyst_name"), "").trim());
                waterConservancyProjectIndex.setDataType(DataTypeEnum.HP.name());
                waterConservancyProjectIndex.setDataTypeDesc(DataTypeEnum.HP.getDesc());
                waterConservancyProjectIndex.setLongitude(Double.parseDouble(Objects.toString(stringObjectMap.get("hyst_long"), "0").trim()));
                waterConservancyProjectIndex.setLatitude(Double.parseDouble(Objects.toString(stringObjectMap.get("hyst_lat"), "0").trim()));
                // attribute
                List<Attribute> attributeList = new ArrayList<>();
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("hyst_site");
                    attribute.setItemName("所在位置");
                    attribute.setValue(stringObjectMap.get("hyst_site"));
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
                    attribute.setItem("main_build_grad");
                    attribute.setItemName("主要建筑物级别");
                    attribute.setValue(stringObjectMap.get("main_build_grad"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("hyst_type");
                    attribute.setItemName("水电站类别");
                    attribute.setValue(stringObjectMap.get("hyst_type"));
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
                    attribute.setItem("ins_cap");
                    attribute.setItemName("装机容量");
                    attribute.setValue(stringObjectMap.get("ins_cap"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("rat_head");
                    attribute.setItemName("额定水头");
                    attribute.setValue(stringObjectMap.get("rat_head"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("firm_pow");
                    attribute.setItemName("保证出力");
                    attribute.setValue(stringObjectMap.get("firm_pow"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("unit_num");
                    attribute.setItemName("机组台数");
                    attribute.setValue(stringObjectMap.get("unit_num"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("avg_power_generation");
                    attribute.setItemName("多年平均发电量");
                    attribute.setValue(stringObjectMap.get("avg_power_generation"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("total_capacity");
                    attribute.setItemName("总装机量");
                    attribute.setValue(stringObjectMap.get("total_capacity"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("max_in_flow");
                    attribute.setItemName("设计引水流量");
                    attribute.setValue(stringObjectMap.get("max_in_flow"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("flat_min_flow");
                    attribute.setItemName("最小下泄流量");
                    attribute.setValue(stringObjectMap.get("flat_min_flow"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("base_flow");
                    attribute.setItemName("生态基流");
                    attribute.setValue(stringObjectMap.get("base_flow"));
                    attributeList.add(attribute);
                }
                waterConservancyProjectIndex.setAttribute(JSON.toJSONString(attributeList));
                return waterConservancyProjectIndex;
            }).collect(Collectors.toList());
            try {
                waterConservancyProjectIndexRepository.saveAll(collect);
                if (log.isInfoEnabled()) {
                    log.info("waterConservancyProjectHPJob执行完成:{}", collect.size());
                }
            } catch (Exception e) {
                log.error("waterConservancyProjectHPJob插入数据错误", e);
            }
        }
        return SUCCESS;
    }
}
