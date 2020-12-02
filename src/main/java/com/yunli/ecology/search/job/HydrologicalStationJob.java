package com.yunli.ecology.search.job;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.yunli.ecology.search.enums.DataTypeEnum;
import com.yunli.ecology.search.index.HydrologicalStationIndex;
import com.yunli.ecology.search.remote.MidDataService;
import com.yunli.ecology.search.remote.request.QueryDataReq;
import com.yunli.ecology.search.repository.es.HydrologicalStationIndexRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author wangyue
 * @date 2020/11/24 6:02 PM
 */
@Slf4j
@Component
@JobHandler(value = "hydrologicalStationJob")
public class HydrologicalStationJob extends IJobHandler {

    @Autowired
    private MidDataService midDataService;
    @Autowired
    private HydrologicalStationIndexRepository hydrologicalStationIndexRepository;

    @Override
    public ReturnT<String> execute(String s) {
        if (log.isInfoEnabled()) {
            log.info("hydrologicalStationJob开始执行");
        }
        // 查询中台
        QueryDataReq queryDataReq = new QueryDataReq();
        queryDataReq.setTableName("adm_zhslyzt_stat");
        queryDataReq.setWhereCond("station_type_code='ZQ'");
        queryDataReq.setQueryFields("station_code,station_name,prov_region_name,city_region_name,district_region_name,lat,lng");
        // 查询数据
        List<Map<String, Object>> data = midDataService.queryData(queryDataReq).isOk();
        if (log.isInfoEnabled()) {
            log.info("hydrologicalStationJob查询出总数据量:{}", data.size());
        }
        // 写入es
        if (!CollectionUtils.isEmpty(data)) {
            List<HydrologicalStationIndex> collect = midDataService.queryData(queryDataReq).isOk().stream().map(stringObjectMap -> {
                HydrologicalStationIndex index = new HydrologicalStationIndex();
                index.setId(Objects.toString(stringObjectMap.get("station_code"), "").trim());
                index.setTableId(index.getId());
                index.setName(Objects.toString(stringObjectMap.get("station_name"), "").trim());
                index.setProvRegionName(Objects.toString(stringObjectMap.get("prov_region_name"), "").trim());
                index.setCityRegionName(Objects.toString(stringObjectMap.get("city_region_name"), "").trim());
                index.setDistrictRegionName(Objects.toString(stringObjectMap.get("district_region_name"), "").trim());
                index.setLongitude(Double.parseDouble(Objects.toString(stringObjectMap.get("lng"), "0").trim()));
                index.setLatitude(Double.parseDouble(Objects.toString(stringObjectMap.get("lat"), "0").trim()));
                index.setDataType(DataTypeEnum.ZQ.name());
                index.setDataTypeDesc(DataTypeEnum.ZQ.getDesc());
                return index;
            }).collect(Collectors.toList());
            try {
                hydrologicalStationIndexRepository.saveAll(collect);
                if (log.isInfoEnabled()) {
                    log.info("hydrologicalStationJob执行完成:{}", collect.size());
                }
            } catch (Exception e) {
                log.error("hydrologicalStationJob插入数据错误", e);
            }
        }
        return SUCCESS;
    }
}
