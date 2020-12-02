package com.yunli.ecology.search.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yunli.ecology.search.component.AppConstant;
import com.yunli.ecology.search.repository.mybatis.YlIotReservoirWaterHourlyMapper;
import com.yunli.ecology.search.schema.entity.YlIotReservoirWaterHourly;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 水库水情监测数据
 *
 * @author wangyue
 * @date 2020/12/1 2:18 PM
 */
@Slf4j
@Component("iotService#RR")
public class ReservoirwaterHourlyIotServiceImpl implements IotService {

    @Autowired
    private YlIotReservoirWaterHourlyMapper reservoirwaterHourlyMapper;

    @Override
    public String queryIotData(String tableId) {
        String iotDataStr = "%s水位%fm";
        QueryWrapper<YlIotReservoirWaterHourly> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.eq("station_code", tableId).orderByDesc("monitor_date_time").last("limit 1");
        YlIotReservoirWaterHourly ylIotReservoirwaterHourly = reservoirwaterHourlyMapper.selectOne(objectQueryWrapper);
        if (null == ylIotReservoirwaterHourly) {
            return AppConstant.DO_NOT_HAVE_IOT_DATA;
        }
        try {
            LocalDateTime monitorDatetime = ylIotReservoirwaterHourly.getMonitorDateTime();
            String monitorDateTimeStr = DateTimeFormatter.ofPattern(AppConstant.DATE_FORMAT_PATTERN2).format(monitorDatetime);
            return null == ylIotReservoirwaterHourly.getWaterLevel() ? AppConstant.DO_NOT_HAVE_IOT_DATA : String.format(iotDataStr, monitorDateTimeStr, ylIotReservoirwaterHourly.getWaterLevel());
        } catch (Exception e) {
            e.printStackTrace();
            return AppConstant.DO_NOT_HAVE_IOT_DATA;
        }
    }
}
