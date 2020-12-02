package com.yunli.ecology.search.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yunli.ecology.search.component.AppConstant;
import com.yunli.ecology.search.repository.mybatis.YlIotRainfallDailyMapper;
import com.yunli.ecology.search.schema.entity.YlIotRainfallDaily;
import com.yunli.smart.ecology.tools.LocalDateTimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * 雨量站监测数据
 *
 * @author wangyue
 * @date 2020/12/1 10:22 AM
 */
@Slf4j
@Component("iotService#PP")
public class RainfallDailyIotServiceImpl implements IotService {

    @Autowired
    private YlIotRainfallDailyMapper rainfallDailyMapper;

    @Override
    public String queryIotData(String tableId) {
        String iotDataStr = "%s8:00---%s8:00 累计降雨量%fmm";
        QueryWrapper<YlIotRainfallDaily> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.eq("station_code", tableId).eq("station_type_code", "PP").orderByDesc("monitor_date").last("limit 1");
        YlIotRainfallDaily ylIotRainfallDaily = rainfallDailyMapper.selectOne(objectQueryWrapper);
        if (null == ylIotRainfallDaily) {
            return AppConstant.DO_NOT_HAVE_IOT_DATA;
        }
        try {
            LocalDateTime monitorDate = ylIotRainfallDaily.getMonitorDate();
            LocalDateTime lastDate = LocalDateTimeUtil.minu(monitorDate, 1, ChronoUnit.DAYS);
            String monitorDateStr = DateTimeFormatter.ofPattern(AppConstant.DATE_FORMAT_PATTERN).format(monitorDate);
            String lastDateStr = DateTimeFormatter.ofPattern(AppConstant.DATE_FORMAT_PATTERN).format(lastDate);
            return null == ylIotRainfallDaily.getDailyAcculate() ? AppConstant.DO_NOT_HAVE_IOT_DATA : String.format(iotDataStr, monitorDateStr, lastDateStr, ylIotRainfallDaily.getDailyAcculate().setScale(2, RoundingMode.HALF_UP));
        } catch (Exception e) {
            e.printStackTrace();
            return AppConstant.DO_NOT_HAVE_IOT_DATA;
        }
    }

}
