package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;

public class WarehouseLocationRecommendation implements Serializable {
    private Integer id;

    private String groundLabel;

    private Integer level;

    private Integer isHeld;

    private Integer isOversize;

    private Integer columns;

    private Integer status;

    private Integer dptId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroundLabel() {
        return groundLabel;
    }

    public void setGroundLabel(String groundLabel) {
        this.groundLabel = groundLabel;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getIsHeld() {
        return isHeld;
    }

    public void setIsHeld(Integer isHeld) {
        this.isHeld = isHeld;
    }

    public Integer getIsOversize() {
        return isOversize;
    }

    public void setIsOversize(Integer isOversize) {
        this.isOversize = isOversize;
    }

    public Integer getColumns() {
        return columns;
    }

    public void setColumns(Integer columns) {
        this.columns = columns;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
        sb.append(", groundLabel=").append(groundLabel);
        sb.append(", level=").append(level);
        sb.append(", isHeld=").append(isHeld);
        sb.append(", isOversize=").append(isOversize);
        sb.append(", columns=").append(columns);
        sb.append(", status=").append(status);
        sb.append(", dptId=").append(dptId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}