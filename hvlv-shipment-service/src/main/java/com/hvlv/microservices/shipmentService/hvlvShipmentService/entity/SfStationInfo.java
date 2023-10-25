package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class SfStationInfo implements Serializable {
    private Integer id;

    private String country;

    private String cityCode;

    private String businessStation;

    private String opStation;

    private String opId;

    private String state;

    private String city;

    private String suburb;

    private String pcLo;

    private String pcHi;

    private String unknow;

    private String region;

    private Integer weekdays;

    private BigDecimal surcharge;

    private String supplier;

    private Integer isEnd;

    private Integer isActive;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getBusinessStation() {
        return businessStation;
    }

    public void setBusinessStation(String businessStation) {
        this.businessStation = businessStation;
    }

    public String getOpStation() {
        return opStation;
    }

    public void setOpStation(String opStation) {
        this.opStation = opStation;
    }

    public String getOpId() {
        return opId;
    }

    public void setOpId(String opId) {
        this.opId = opId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getPcLo() {
        return pcLo;
    }

    public void setPcLo(String pcLo) {
        this.pcLo = pcLo;
    }

    public String getPcHi() {
        return pcHi;
    }

    public void setPcHi(String pcHi) {
        this.pcHi = pcHi;
    }

    public String getUnknow() {
        return unknow;
    }

    public void setUnknow(String unknow) {
        this.unknow = unknow;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Integer getWeekdays() {
        return weekdays;
    }

    public void setWeekdays(Integer weekdays) {
        this.weekdays = weekdays;
    }

    public BigDecimal getSurcharge() {
        return surcharge;
    }

    public void setSurcharge(BigDecimal surcharge) {
        this.surcharge = surcharge;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public Integer getIsEnd() {
        return isEnd;
    }

    public void setIsEnd(Integer isEnd) {
        this.isEnd = isEnd;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", country=").append(country);
        sb.append(", cityCode=").append(cityCode);
        sb.append(", businessStation=").append(businessStation);
        sb.append(", opStation=").append(opStation);
        sb.append(", opId=").append(opId);
        sb.append(", state=").append(state);
        sb.append(", city=").append(city);
        sb.append(", suburb=").append(suburb);
        sb.append(", pcLo=").append(pcLo);
        sb.append(", pcHi=").append(pcHi);
        sb.append(", unknow=").append(unknow);
        sb.append(", region=").append(region);
        sb.append(", weekdays=").append(weekdays);
        sb.append(", surcharge=").append(surcharge);
        sb.append(", supplier=").append(supplier);
        sb.append(", isEnd=").append(isEnd);
        sb.append(", isActive=").append(isActive);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}