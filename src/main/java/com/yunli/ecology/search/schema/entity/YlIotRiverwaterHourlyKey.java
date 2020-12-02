package com.yunli.ecology.search.schema.entity;

import java.time.LocalDateTime;

public class YlIotRiverwaterHourlyKey {
    private String stationCode;

    private LocalDateTime monitorDateTime;

    public String getStationCode() {
        return stationCode;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode == null ? null : stationCode.trim();
    }

    public LocalDateTime getMonitorDateTime() {
        return monitorDateTime;
    }

    public void setMonitorDateTime(LocalDateTime monitorDateTime) {
        this.monitorDateTime = monitorDateTime;
    }
}