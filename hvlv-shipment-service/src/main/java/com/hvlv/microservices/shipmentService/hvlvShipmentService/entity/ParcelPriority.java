package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;

public class ParcelPriority implements Serializable {
    private Integer id;

    private Integer parcelType;

    private Integer priority;

    private Integer areaType;

    private Integer isOversize;

    private Integer dptId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParcelType() {
        return parcelType;
    }

    public void setParcelType(Integer parcelType) {
        this.parcelType = parcelType;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getAreaType() {
        return areaType;
    }

    public void setAreaType(Integer areaType) {
        this.areaType = areaType;
    }

    public Integer getIsOversize() {
        return isOversize;
    }

    public void setIsOversize(Integer isOversize) {
        this.isOversize = isOversize;
    }

    public Integer getDptId() {
        return dptId;
    }

    public void setDptId(Integer dptId) {
        this.dptId = dptId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", parcelType=").append(parcelType);
        sb.append(", priority=").append(priority);
        sb.append(", areaType=").append(areaType);
        sb.append(", isOversize=").append(isOversize);
        sb.append(", dptId=").append(dptId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}