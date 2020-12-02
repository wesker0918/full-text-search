package com.yunli.ecology.search.schema.entity;

public class YlIotSoilMonth3PeriodKey {
    private String stationCode;

    private String monitorFreqYm;

    private Byte monitorMonthPeirod;

    public String getStationCode() {
        return stationCode;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode == null ? null : stationCode.trim();
    }

    public String getMonitorFreqYm() {
        return monitorFreqYm;
    }

    public void setMonitorFreqYm(String monitorFreqYm) {
        this.monitorFreqYm = monitorFreqYm == null ? null : monitorFreqYm.trim();
    }

    public Byte getMonitorMonthPeirod() {
        return monitorMonthPeirod;
    }

    public void setMonitorMonthPeirod(Byte monitorMonthPeirod) {
        this.monitorMonthPeirod = monitorMonthPeirod;
    }
}