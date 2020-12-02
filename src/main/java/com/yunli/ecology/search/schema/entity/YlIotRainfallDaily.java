package com.yunli.ecology.search.schema.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.util.Date;

@TableName("yl_iot_rainfall_daily")
public class YlIotRainfallDaily extends YlIotRainfallDailyKey {
    private String stationName;

    private String stationTypeCode;

    private String stationTypeName;

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

    private Integer monitorYear;

    private Byte monitorMonth;

    private Byte monitorDay;

    private BigDecimal dailyAcculate;

    private BigDecimal timePeriod;

    private String remark;

    private Date createTime;

    private Date updateTime;

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName == null ? null : stationName.trim();
    }

    public String getStationTypeCode() {
        return stationTypeCode;
    }

    public void setStationTypeCode(String stationTypeCode) {
        this.stationTypeCode = stationTypeCode == null ? null : stationTypeCode.trim();
    }

    public String getStationTypeName() {
        return stationTypeName;
    }

    public void setStationTypeName(String stationTypeName) {
        this.stationTypeName = stationTypeName == null ? null : stationTypeName.trim();
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

    public Integer getMonitorYear() {
        return monitorYear;
    }

    public void setMonitorYear(Integer monitorYear) {
        this.monitorYear = monitorYear;
    }

    public Byte getMonitorMonth() {
        return monitorMonth;
    }

    public void setMonitorMonth(Byte monitorMonth) {
        this.monitorMonth = monitorMonth;
    }

    public Byte getMonitorDay() {
        return monitorDay;
    }

    public void setMonitorDay(Byte monitorDay) {
        this.monitorDay = monitorDay;
    }

    public BigDecimal getDailyAcculate() {
        return dailyAcculate;
    }

    public void setDailyAcculate(BigDecimal dailyAcculate) {
        this.dailyAcculate = dailyAcculate;
    }

    public BigDecimal getTimePeriod() {
        return timePeriod;
    }

    public void setTimePeriod(BigDecimal timePeriod) {
        this.timePeriod = timePeriod;
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