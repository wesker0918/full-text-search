package com.yunli.ecology.search.schema.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.util.Date;

@TableName("yl_iot_reservoirwater_hourly")
public class YlIotReservoirWaterHourly extends YlIotReservoirWaterHourlyKey {
    private String stationName;

    private String stationTypeCode;

    private String stationTypeName;

    private Date orginMonitorDateTime;

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

    private BigDecimal inFlow;

    private BigDecimal outFlow;

    private BigDecimal waterLevel;

    private BigDecimal monitorCapacity;

    private Byte waterLevelVariety;

    private String waterLevelVarietyName;

    private Date latestMonitorDateTime;

    private BigDecimal latestInFlow;

    private BigDecimal latestOutFlow;

    private BigDecimal latestWaterLevel;

    private BigDecimal latestMonitorCapacity;

    private BigDecimal totalCapacity;

    private BigDecimal nomalWaterLevel;

    private String reservoirGrade;

    private String reservoirGradeName;

    private BigDecimal floodLowLimitLevel;

    private BigDecimal floodLowLimitCapacity;

    private String floodSeasonTypeCode;

    private String floodSeasonTypeName;

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

    public Date getOrginMonitorDateTime() {
        return orginMonitorDateTime;
    }

    public void setOrginMonitorDateTime(Date orginMonitorDateTime) {
        this.orginMonitorDateTime = orginMonitorDateTime;
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

    public BigDecimal getInFlow() {
        return inFlow;
    }

    public void setInFlow(BigDecimal inFlow) {
        this.inFlow = inFlow;
    }

    public BigDecimal getOutFlow() {
        return outFlow;
    }

    public void setOutFlow(BigDecimal outFlow) {
        this.outFlow = outFlow;
    }

    public BigDecimal getWaterLevel() {
        return waterLevel;
    }

    public void setWaterLevel(BigDecimal waterLevel) {
        this.waterLevel = waterLevel;
    }

    public BigDecimal getMonitorCapacity() {
        return monitorCapacity;
    }

    public void setMonitorCapacity(BigDecimal monitorCapacity) {
        this.monitorCapacity = monitorCapacity;
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

    public BigDecimal getLatestInFlow() {
        return latestInFlow;
    }

    public void setLatestInFlow(BigDecimal latestInFlow) {
        this.latestInFlow = latestInFlow;
    }

    public BigDecimal getLatestOutFlow() {
        return latestOutFlow;
    }

    public void setLatestOutFlow(BigDecimal latestOutFlow) {
        this.latestOutFlow = latestOutFlow;
    }

    public BigDecimal getLatestWaterLevel() {
        return latestWaterLevel;
    }

    public void setLatestWaterLevel(BigDecimal latestWaterLevel) {
        this.latestWaterLevel = latestWaterLevel;
    }

    public BigDecimal getLatestMonitorCapacity() {
        return latestMonitorCapacity;
    }

    public void setLatestMonitorCapacity(BigDecimal latestMonitorCapacity) {
        this.latestMonitorCapacity = latestMonitorCapacity;
    }

    public BigDecimal getTotalCapacity() {
        return totalCapacity;
    }

    public void setTotalCapacity(BigDecimal totalCapacity) {
        this.totalCapacity = totalCapacity;
    }

    public BigDecimal getNomalWaterLevel() {
        return nomalWaterLevel;
    }

    public void setNomalWaterLevel(BigDecimal nomalWaterLevel) {
        this.nomalWaterLevel = nomalWaterLevel;
    }

    public String getReservoirGrade() {
        return reservoirGrade;
    }

    public void setReservoirGrade(String reservoirGrade) {
        this.reservoirGrade = reservoirGrade == null ? null : reservoirGrade.trim();
    }

    public String getReservoirGradeName() {
        return reservoirGradeName;
    }

    public void setReservoirGradeName(String reservoirGradeName) {
        this.reservoirGradeName = reservoirGradeName == null ? null : reservoirGradeName.trim();
    }

    public BigDecimal getFloodLowLimitLevel() {
        return floodLowLimitLevel;
    }

    public void setFloodLowLimitLevel(BigDecimal floodLowLimitLevel) {
        this.floodLowLimitLevel = floodLowLimitLevel;
    }

    public BigDecimal getFloodLowLimitCapacity() {
        return floodLowLimitCapacity;
    }

    public void setFloodLowLimitCapacity(BigDecimal floodLowLimitCapacity) {
        this.floodLowLimitCapacity = floodLowLimitCapacity;
    }

    public String getFloodSeasonTypeCode() {
        return floodSeasonTypeCode;
    }

    public void setFloodSeasonTypeCode(String floodSeasonTypeCode) {
        this.floodSeasonTypeCode = floodSeasonTypeCode == null ? null : floodSeasonTypeCode.trim();
    }

    public String getFloodSeasonTypeName() {
        return floodSeasonTypeName;
    }

    public void setFloodSeasonTypeName(String floodSeasonTypeName) {
        this.floodSeasonTypeName = floodSeasonTypeName == null ? null : floodSeasonTypeName.trim();
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