package com.yunli.ecology.search.schema.entity;

import java.math.BigDecimal;
import java.util.Date;

public class YlIotRiverwaterHourly extends YlIotRiverwaterHourlyKey {
    private String stationName;

    private Date orginMonitorTime;

    private String provRegionCode;

    private String provRegionName;

    private String cityRegionCode;

    private String cityRegionName;

    private String districtRegionCode;

    private String districtRegionName;

    private BigDecimal lng;

    private BigDecimal lat;

    private String stationLoc;

    private String watershedCode;

    private String watershedName;

    private String riversysCode;

    private String riversysName;

    private String riverCode;

    private String riverName;

    private String monitorDate;

    private Byte monitorHour;

    private BigDecimal waterLevel;

    private BigDecimal waterFlow;

    private Byte waterLevelVariety;

    private String waterLevelVarietyName;

    private Date latestMonitorDateTime;

    private BigDecimal latestWaterLevel;

    private BigDecimal latestWaterFlow;

    private BigDecimal warningWaterLevel;

    private BigDecimal warningWaterFlow;

    private BigDecimal safetyWaterLevel;

    private BigDecimal safetyWaterFlow;

    private String remark;

    private Date createTime;

    private Date updateTime;

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName == null ? null : stationName.trim();
    }

    public Date getOrginMonitorTime() {
        return orginMonitorTime;
    }

    public void setOrginMonitorTime(Date orginMonitorTime) {
        this.orginMonitorTime = orginMonitorTime;
    }

    public String getProvRegionCode() {
        return provRegionCode;
    }

    public void setProvRegionCode(String provRegionCode) {
        this.provRegionCode = provRegionCode == null ? null : provRegionCode.trim();
    }

    public String getProvRegionName() {
        return provRegionName;
    }

    public void setProvRegionName(String provRegionName) {
        this.provRegionName = provRegionName == null ? null : provRegionName.trim();
    }

    public String getCityRegionCode() {
        return cityRegionCode;
    }

    public void setCityRegionCode(String cityRegionCode) {
        this.cityRegionCode = cityRegionCode == null ? null : cityRegionCode.trim();
    }

    public String getCityRegionName() {
        return cityRegionName;
    }

    public void setCityRegionName(String cityRegionName) {
        this.cityRegionName = cityRegionName == null ? null : cityRegionName.trim();
    }

    public String getDistrictRegionCode() {
        return districtRegionCode;
    }

    public void setDistrictRegionCode(String districtRegionCode) {
        this.districtRegionCode = districtRegionCode == null ? null : districtRegionCode.trim();
    }

    public String getDistrictRegionName() {
        return districtRegionName;
    }

    public void setDistrictRegionName(String districtRegionName) {
        this.districtRegionName = districtRegionName == null ? null : districtRegionName.trim();
    }

    public BigDecimal getLng() {
        return lng;
    }

    public void setLng(BigDecimal lng) {
        this.lng = lng;
    }

    public BigDecimal getLat() {
        return lat;
    }

    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }

    public String getStationLoc() {
        return stationLoc;
    }

    public void setStationLoc(String stationLoc) {
        this.stationLoc = stationLoc == null ? null : stationLoc.trim();
    }

    public String getWatershedCode() {
        return watershedCode;
    }

    public void setWatershedCode(String watershedCode) {
        this.watershedCode = watershedCode == null ? null : watershedCode.trim();
    }

    public String getWatershedName() {
        return watershedName;
    }

    public void setWatershedName(String watershedName) {
        this.watershedName = watershedName == null ? null : watershedName.trim();
    }

    public String getRiversysCode() {
        return riversysCode;
    }

    public void setRiversysCode(String riversysCode) {
        this.riversysCode = riversysCode == null ? null : riversysCode.trim();
    }

    public String getRiversysName() {
        return riversysName;
    }

    public void setRiversysName(String riversysName) {
        this.riversysName = riversysName == null ? null : riversysName.trim();
    }

    public String getRiverCode() {
        return riverCode;
    }

    public void setRiverCode(String riverCode) {
        this.riverCode = riverCode == null ? null : riverCode.trim();
    }

    public String getRiverName() {
        return riverName;
    }

    public void setRiverName(String riverName) {
        this.riverName = riverName == null ? null : riverName.trim();
    }

    public String getMonitorDate() {
        return monitorDate;
    }

    public void setMonitorDate(String monitorDate) {
        this.monitorDate = monitorDate == null ? null : monitorDate.trim();
    }

    public Byte getMonitorHour() {
        return monitorHour;
    }

    public void setMonitorHour(Byte monitorHour) {
        this.monitorHour = monitorHour;
    }

    public BigDecimal getWaterLevel() {
        return waterLevel;
    }

    public void setWaterLevel(BigDecimal waterLevel) {
        this.waterLevel = waterLevel;
    }

    public BigDecimal getWaterFlow() {
        return waterFlow;
    }

    public void setWaterFlow(BigDecimal waterFlow) {
        this.waterFlow = waterFlow;
    }

    public Byte getWaterLevelVariety() {
        return waterLevelVariety;
    }

    public void setWaterLevelVariety(Byte waterLevelVariety) {
        this.waterLevelVariety = waterLevelVariety;
    }

    public String getWaterLevelVarietyName() {
        return waterLevelVarietyName;
    }

    public void setWaterLevelVarietyName(String waterLevelVarietyName) {
        this.waterLevelVarietyName = waterLevelVarietyName == null ? null : waterLevelVarietyName.trim();
    }

    public Date getLatestMonitorDateTime() {
        return latestMonitorDateTime;
    }

    public void setLatestMonitorDateTime(Date latestMonitorDateTime) {
        this.latestMonitorDateTime = latestMonitorDateTime;
    }

    public BigDecimal getLatestWaterLevel() {
        return latestWaterLevel;
    }

    public void setLatestWaterLevel(BigDecimal latestWaterLevel) {
        this.latestWaterLevel = latestWaterLevel;
    }

    public BigDecimal getLatestWaterFlow() {
        return latestWaterFlow;
    }

    public void setLatestWaterFlow(BigDecimal latestWaterFlow) {
        this.latestWaterFlow = latestWaterFlow;
    }

    public BigDecimal getWarningWaterLevel() {
        return warningWaterLevel;
    }

    public void setWarningWaterLevel(BigDecimal warningWaterLevel) {
        this.warningWaterLevel = warningWaterLevel;
    }

    public BigDecimal getWarningWaterFlow() {
        return warningWaterFlow;
    }

    public void setWarningWaterFlow(BigDecimal warningWaterFlow) {
        this.warningWaterFlow = warningWaterFlow;
    }

    public BigDecimal getSafetyWaterLevel() {
        return safetyWaterLevel;
    }

    public void setSafetyWaterLevel(BigDecimal safetyWaterLevel) {
        this.safetyWaterLevel = safetyWaterLevel;
    }

    public BigDecimal getSafetyWaterFlow() {
        return safetyWaterFlow;
    }

    public void setSafetyWaterFlow(BigDecimal safetyWaterFlow) {
        this.safetyWaterFlow = safetyWaterFlow;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}