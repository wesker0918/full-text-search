package com.yunli.ecology.search.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yunli.ecology.search.component.AppConstant;
import com.yunli.ecology.search.repository.mybatis.YlIotSoilMonth3PeriodMapper;
import com.yunli.ecology.search.schema.entity.YlIotSoilMonth3Period;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author wangyue
 * @date 2020/12/1 2:43 PM
 */
@Slf4j
@Component("iotService#SS")
public class SoilMonth3PeriodIotServiceImpl implements IotService {
    @Autowired
    private YlIotSoilMonth3PeriodMapper soilMonth3PeriodMapper;

    @Override
    public String queryIotData(String tableId) {
        String iotDataStr = "%s土壤含水率:\n10cm:%f%  20cm:%f%  40cm:%f%";
        QueryWrapper<YlIotSoilMonth3Period> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.eq("station_code", tableId).orderByDesc("monitor_date_time").last("limit 1");
        YlIotSoilMonth3Period ylIotSoilMonth3Period = soilMonth3PeriodMapper.selectOne(objectQueryWrapper);
        if (null == ylIotSoilMonth3Period) {
            return AppConstant.DO_NOT_HAVE_IOT_DATA;
        }
        try {
            LocalDateTime monitorDatetime = ylIotSoilMonth3Period.getMonitorDateTime();
            String monitorDateTimeStr = DateTimeFormatter.ofPattern(AppConstant.DATE_FORMAT_PATTERN).format(monitorDatetime);
            return String.format(iotDataStr, monitorDateTimeStr, ylIotSoilMonth3Period.getSoilMoisture10cm(), ylIotSoilMonth3Period.getSoilMoisture20cm(), ylIotSoilMonth3Period.getSoilMoisture40cm());
        } catch (Exception e) {
            e.printStackTrace();
            return AppConstant.DO_NOT_HAVE_IOT_DATA;
        }
    }
}
