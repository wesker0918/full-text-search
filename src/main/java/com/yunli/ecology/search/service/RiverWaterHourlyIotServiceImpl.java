package com.yunli.ecology.search.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yunli.ecology.search.component.AppConstant;
import com.yunli.ecology.search.repository.mybatis.YlIotRiverWaterHourlyMapper;
import com.yunli.ecology.search.schema.entity.YlIotRiverwaterHourly;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 河道水情监测数据
 *
 * @author wangyue
 * @date 2020/12/1 2:36 PM
 */
@Slf4j
@Component("iotService#ZQ")
public class RiverWaterHourlyIotServiceImpl implements IotService {

    @Autowired
    private YlIotRiverWaterHourlyMapper riverWaterHourlyMapper;

    @Override
    public String queryIotData(String tableId) {
        String iotDataStr = "%s水位%fm";
        QueryWrapper<YlIotRiverwaterHourly> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.eq("station_code", tableId).orderByDesc("monitor_date_time").last("limit 1");
        YlIotRiverwaterHourly ylIotRiverWaterHourly = riverWaterHourlyMapper.selectOne(objectQueryWrapper);
        if (null == ylIotRiverWaterHourly) {
            return AppConstant.DO_NOT_HAVE_IOT_DATA;
        }
        try {
            LocalDateTime monitorDatetime = ylIotRiverWaterHourly.getMonitorDateTime();
            String monitorDateTimeStr = DateTimeFormatter.ofPattern(AppConstant.DATE_FORMAT_PATTERN2).format(monitorDatetime);
            return null == ylIotRiverWaterHourly.getWaterLevel() ? AppConstant.DO_NOT_HAVE_IOT_DATA : String.format(iotDataStr, monitorDateTimeStr, ylIotRiverWaterHourly.getWaterLevel());
        } catch (Exception e) {
            e.printStackTrace();
            return AppConstant.DO_NOT_HAVE_IOT_DATA;
        }
    }
}
