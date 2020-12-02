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
@JobHandler(value = "waterConservancyProjectDikeJob")
public class WaterConservancyProjectDikeJob extends IJobHandler {

    @Autowired
    private MidDataService midDataService;
    @Autowired
    private WaterConservancyProjectIndexRepository waterConservancyProjectIndexRepository;

    @Override
    public ReturnT<String> execute(String s) {
        if (log.isInfoEnabled()) {
            log.info("waterConservancyProjectDIKEJob开始执行");
        }
        // 查询中台
        QueryDataReq queryDataReq = new QueryDataReq();
        queryDataReq.setTableName("adm_zhslyzt_dike");
        // 查询数据
        List<Map<String, Object>> data = midDataService.queryData(queryDataReq).isOk();
        if (log.isInfoEnabled()) {
            log.info("waterConservancyProjectDIKEJob查询出总数据量:{}", data.size());
        }
        // 写入es
        if (!CollectionUtils.isEmpty(data)) {
            List<WaterConservancyProjectIndex> collect = midDataService.queryData(queryDataReq).isOk().stream().map(stringObjectMap -> {
                WaterConservancyProjectIndex waterConservancyProjectIndex = new WaterConservancyProjectIndex();
                waterConservancyProjectIndex.setId(WaterConservancyProjectTypeEnum.DIKE.name() + Objects.toString(stringObjectMap.get("dike_code"), "").trim());
                waterConservancyProjectIndex.setTableId(Objects.toString(stringObjectMap.get("dike_code"), "").trim());
                waterConservancyProjectIndex.setName(Objects.toString(stringObjectMap.get("dike_name"), "").trim());
                waterConservancyProjectIndex.setDataType(DataTypeEnum.DIKE.name());
                waterConservancyProjectIndex.setDataTypeDesc(DataTypeEnum.DIKE.getDesc());
                waterConservancyProjectIndex.setLongitude(Double.parseDouble(Objects.toString(stringObjectMap.get("start_long"), "0").trim()));
                waterConservancyProjectIndex.setLatitude(Double.parseDouble(Objects.toString(stringObjectMap.get("start_lat"), "0").trim()));
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
                    attribute.setItem("dike_res_code");
                    attribute.setItemName("所属水库编码");
                    attribute.setValue(stringObjectMap.get("dike_res_code"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("start_long");
                    attribute.setItemName("起点经度");
                    attribute.setValue(stringObjectMap.get("start_long"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("start_lat");
                    attribute.setItemName("起点纬度");
                    attribute.setValue(stringObjectMap.get("start_lat"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("end_long");
                    attribute.setItemName("终点经度");
                    attribute.setValue(stringObjectMap.get("end_long"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("end_lat");
                    attribute.setItemName("终点纬度");
                    attribute.setValue(stringObjectMap.get("end_lat"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("dike_loc");
                    attribute.setItemName("位置");
                    attribute.setValue(stringObjectMap.get("dike_loc"));
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
                    attribute.setItem("dike_grad");
                    attribute.setItemName("堤防级别");
                    attribute.setValue(stringObjectMap.get("dike_grad"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("dike_patt");
                    attribute.setItemName("堤防型式");
                    attribute.setValue(stringObjectMap.get("dike_patt"));
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
                    attribute.setItem("plan_norm");
                    attribute.setItemName("规划防洪标准");
                    attribute.setValue(stringObjectMap.get("plan_norm"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("start_dike_top_el");
                    attribute.setItemName("起点堤顶高程");
                    attribute.setValue(stringObjectMap.get("start_dike_top_el"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("end_dike_top_el");
                    attribute.setItemName("终点堤顶高程");
                    attribute.setValue(stringObjectMap.get("end_dike_top_el"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("design_level");
                    attribute.setItemName("设计(高潮)水位");
                    attribute.setValue(stringObjectMap.get("design_level"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("dike_len");
                    attribute.setItemName("堤防长度");
                    attribute.setValue(stringObjectMap.get("dike_len"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("reach_length");
                    attribute.setItemName("达到规划防洪长度");
                    attribute.setValue(stringObjectMap.get("reach_length"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("dike_heig_max");
                    attribute.setItemName("最大堤防高程");
                    attribute.setValue(stringObjectMap.get("dike_heig_max"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("dike_heig_min");
                    attribute.setItemName("最小堤防高程");
                    attribute.setValue(stringObjectMap.get("dike_heig_min"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("dike_top_wid_max");
                    attribute.setItemName("最大堤顶宽度");
                    attribute.setValue(stringObjectMap.get("dike_top_wid_max"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("dike_top_wid_min");
                    attribute.setItemName("最小堤顶宽度");
                    attribute.setValue(stringObjectMap.get("dike_top_wid_min"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("sluice_num");
                    attribute.setItemName("水闸数量");
                    attribute.setValue(stringObjectMap.get("sluice_num"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("pipe_num");
                    attribute.setItemName("管涵数量");
                    attribute.setValue(stringObjectMap.get("pipe_num"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("pump_num");
                    attribute.setItemName("泵站数量");
                    attribute.setValue(stringObjectMap.get("pump_num"));
                    attributeList.add(attribute);
                }
                {
                    Attribute attribute = new Attribute();
                    attribute.setItem("inverted_sip_num");
                    attribute.setItemName("倒吸虹数量");
                    attribute.setValue(stringObjectMap.get("inverted_sip_num"));
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
                    attribute.setItem("dike_type");
                    attribute.setItemName("类型");
                    attribute.setValue(stringObjectMap.get("dike_type"));
                    attributeList.add(attribute);
                }
                waterConservancyProjectIndex.setAttribute(JSON.toJSONString(attributeList));
                return waterConservancyProjectIndex;
            }).collect(Collectors.toList());
            try {
                waterConservancyProjectIndexRepository.saveAll(collect);
                if (log.isInfoEnabled()) {
                    log.info("waterConservancyProjectDIKEJob执行完成:{}", collect.size());
                }
            } catch (Exception e) {
                log.error("waterConservancyProjectDIKEJob插入数据错误", e);
            }
        }
        return SUCCESS;
    }
}
