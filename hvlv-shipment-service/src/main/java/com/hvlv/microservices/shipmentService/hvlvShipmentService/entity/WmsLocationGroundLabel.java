package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;
import java.util.Date;

public class WmsLocationGroundLabel implements Serializable {
    private Integer id;

    private Integer locationId;

    private String groundLabel;

    private Date groundLabelInTime;

    private Integer userId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public String getGroundLabel() {
        return groundLabel;
    }

    public void setGroundLabel(String groundLabel) {
        this.groundLabel = groundLabel;
    }

    public Date getGroundLabelInTime() {
        return groundLabelInTime;
    }

    public void setGroundLabelInTime(Date groundLabelInTime) {
        this.groundLabelInTime = groundLabelInTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", locationId=").append(locationId);
        sb.append(", groundLabel=").append(groundLabel);
        sb.append(", groundLabelInTime=").append(groundLabelInTime);
        sb.append(", userId=").append(userId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}