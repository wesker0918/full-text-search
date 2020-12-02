package com.yunli.ecology.search.schema.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@TableName("yl_iot_soil_month_3period")
public class YlIotSoilMonth3Period extends YlIotSoilMonth3PeriodKey {
    private String stationName;

    private String stationTypeCode;

    private String stationTypeName;

    private String monitorMonthPeirodName;

    private String monitorFreqQuery;

    private LocalDateTime monitorDateTime;

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

    @TableField(value = "soil_moisture_10cm")
    private BigDecimal soilMoisture10cm;

    @TableField(value = "soil_moisture_20cm")
    private BigDecimal soilMoisture20cm;

    @TableField(value = "soil_moisture_30cm")
    private BigDecimal soilMoisture30cm;

    @TableField(value = "soil_moisture_40cm")
    private BigDecimal soilMoisture40cm;

    @TableField(value = "soil_moisture_60cm")
    private BigDecimal soilMoisture60cm;

    @TableField(value = "soil_moisture_80cm")
    private BigDecimal soilMoisture80cm;

    @TableField(value = "soil_moisture_100cm")
    private BigDecimal soilMoisture100cm;

    private String soilTypeCode;

    private String soilTypeName;

    private BigDecimal featureFieldCapacity;

    private String featureComments;

    private Date featureModitime;

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

    public String getMonitorMonthPeirodName() {
        return monitorMonthPeirodName;
    }

    public void setMonitorMonthPeirodName(String monitorMonthPeirodName) {
        this.monitorMonthPeirodName = monitorMonthPeirodName == null ? null : monitorMonthPeirodName.trim();
    }

    public String getMonitorFreqQuery() {
        return monitorFreqQuery;
    }

    public void setMonitorFreqQuery(String monitorFreqQuery) {
        this.monitorFreqQuery = monitorFreqQuery == null ? null : monitorFreqQuery.trim();
    }

    public LocalDateTime getMonitorDateTime() {
        return monitorDateTime;
    }

    public void setMonitorDateTime(LocalDateTime monitorDateTime) {
        this.monitorDateTime = monitorDateTime;
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

    public BigDecimal getSoilMoisture10cm() {
        return soilMoisture10cm;
    }

    public void setSoilMoisture10cm(BigDecimal soilMoisture10cm) {
        this.soilMoisture10cm = soilMoisture10cm;
    }

    public BigDecimal getSoilMoisture20cm() {
        return soilMoisture20cm;
    }

    public void setSoilMoisture20cm(BigDecimal soilMoisture20cm) {
        this.soilMoisture20cm = soilMoisture20cm;
    }

    public BigDecimal getSoilMoisture30cm() {
        return soilMoisture30cm;
    }

    public void setSoilMoisture30cm(BigDecimal soilMoisture30cm) {
        this.soilMoisture30cm = soilMoisture30cm;
    }

    public BigDecimal getSoilMoisture40cm() {
        return soilMoisture40cm;
    }

    public void setSoilMoisture40cm(BigDecimal soilMoisture40cm) {
        this.soilMoisture40cm = soilMoisture40cm;
    }

    public BigDecimal getSoilMoisture60cm() {
        return soilMoisture60cm;
    }

    public void setSoilMoisture60cm(BigDecimal soilMoisture60cm) {
        this.soilMoisture60cm = soilMoisture60cm;
    }

    public BigDecimal getSoilMoisture80cm() {
        return soilMoisture80cm;
    }

    public void setSoilMoisture80cm(BigDecimal soilMoisture80cm) {
        this.soilMoisture80cm = soilMoisture80cm;
    }

    public BigDecimal getSoilMoisture100cm() {
        return soilMoisture100cm;
    }

    public void setSoilMoisture100cm(BigDecimal soilMoisture100cm) {
        this.soilMoisture100cm = soilMoisture100cm;
    }

    public String getSoilTypeCode() {
        return soilTypeCode;
    }

    public void setSoilTypeCode(String soilTypeCode) {
        this.soilTypeCode = soilTypeCode == null ? null : soilTypeCode.trim();
    }

    public String getSoilTypeName() {
        return soilTypeName;
    }

    public void setSoilTypeName(String soilTypeName) {
        this.soilTypeName = soilTypeName == null ? null : soilTypeName.trim();
    }

    public BigDecimal getFeatureFieldCapacity() {
        return featureFieldCapacity;
    }

    public void setFeatureFieldCapacity(BigDecimal featureFieldCapacity) {
        this.featureFieldCapacity = featureFieldCapacity;
    }

    public String getFeatureComments() {
        return featureComments;
    }

    public void setFeatureComments(String featureComments) {
        this.featureComments = featureComments == null ? null : featureComments.trim();
    }

    public Date getFeatureModitime() {
        return featureModitime;
    }

    public void setFeatureModitime(Date featureModitime) {
        this.featureModitime = featureModitime;
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