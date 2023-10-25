package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;
import java.util.Date;

public class ShipmentScanOverview implements Serializable {
    private Integer id;

    private Date date;

    private Integer dptId;

    private Integer preLeftPacks;

    private Float preLeftWeight;

    private Integer todayPacks;

    private Float todayWeight;

    private Integer todayLeftPacks;

    private Float todayLeftWeight;

    private Integer type;

    private String meta;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getDptId() {
        return dptId;
    }

    public void setDptId(Integer dptId) {
        this.dptId = dptId;
    }

    public Integer getPreLeftPacks() {
        return preLeftPacks;
    }

    public void setPreLeftPacks(Integer preLeftPacks) {
        this.preLeftPacks = preLeftPacks;
    }

    public Float getPreLeftWeight() {
        return preLeftWeight;
    }

    public void setPreLeftWeight(Float preLeftWeight) {
        this.preLeftWeight = preLeftWeight;
    }

    public Integer getTodayPacks() {
        return todayPacks;
    }

    public void setTodayPacks(Integer todayPacks) {
        this.todayPacks = todayPacks;
    }

    public Float getTodayWeight() {
        return todayWeight;
    }

    public void setTodayWeight(Float todayWeight) {
        this.todayWeight = todayWeight;
    }

    public Integer getTodayLeftPacks() {
        return todayLeftPacks;
    }

    public void setTodayLeftPacks(Integer todayLeftPacks) {
        this.todayLeftPacks = todayLeftPacks;
    }

    public Float getTodayLeftWeight() {
        return todayLeftWeight;
    }

    public void setTodayLeftWeight(Float todayLeftWeight) {
        this.todayLeftWeight = todayLeftWeight;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", date=").append(date);
        sb.append(", dptId=").append(dptId);
        sb.append(", preLeftPacks=").append(preLeftPacks);
        sb.append(", preLeftWeight=").append(preLeftWeight);
        sb.append(", todayPacks=").append(todayPacks);
        sb.append(", todayWeight=").append(todayWeight);
        sb.append(", todayLeftPacks=").append(todayLeftPacks);
        sb.append(", todayLeftWeight=").append(todayLeftWeight);
        sb.append(", type=").append(type);
        sb.append(", meta=").append(meta);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}