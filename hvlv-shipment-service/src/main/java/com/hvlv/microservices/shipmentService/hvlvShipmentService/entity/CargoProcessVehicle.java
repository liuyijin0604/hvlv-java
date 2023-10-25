package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;

public class CargoProcessVehicle implements Serializable {
    private Integer id;

    private Short type;

    private String vehicleName;

    private Float minCbm;

    private Float maxCbm;

    private Integer topWidth;

    private Integer bottomWidth;

    private Integer height;

    private Integer length;

    private Short status;

    private String meta;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public Float getMinCbm() {
        return minCbm;
    }

    public void setMinCbm(Float minCbm) {
        this.minCbm = minCbm;
    }

    public Float getMaxCbm() {
        return maxCbm;
    }

    public void setMaxCbm(Float maxCbm) {
        this.maxCbm = maxCbm;
    }

    public Integer getTopWidth() {
        return topWidth;
    }

    public void setTopWidth(Integer topWidth) {
        this.topWidth = topWidth;
    }

    public Integer getBottomWidth() {
        return bottomWidth;
    }

    public void setBottomWidth(Integer bottomWidth) {
        this.bottomWidth = bottomWidth;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
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
        sb.append(", type=").append(type);
        sb.append(", vehicleName=").append(vehicleName);
        sb.append(", minCbm=").append(minCbm);
        sb.append(", maxCbm=").append(maxCbm);
        sb.append(", topWidth=").append(topWidth);
        sb.append(", bottomWidth=").append(bottomWidth);
        sb.append(", height=").append(height);
        sb.append(", length=").append(length);
        sb.append(", status=").append(status);
        sb.append(", meta=").append(meta);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}