package com.yunli.ecology.search.schema.entity;

import java.time.LocalDateTime;

public class YlIotRainfallDailyKey {
    private String stationCode;

    private LocalDateTime monitorDate;

    public String getStationCode() {
        return stationCode;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode == null ? null : stationCode.trim();
    }

    public LocalDateTime getMonitorDate() {
        return monitorDate;
    }

    public void setMonitorDate(LocalDateTime monitorDate) {
        this.monitorDate = monitorDate;
    }
}