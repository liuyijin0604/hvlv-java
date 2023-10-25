package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;
import java.util.Date;

public class ImportsUnknownShipment implements Serializable {
    private Integer id;

    private Integer status;

    private String barcode;

    private String tempBarcode;

    private Integer userId;

    private Date createTime;

    private String locationId;

    private String containerNo;

    private String groundLabel;

    private Integer consolId;

    private Integer print;

    private Integer shipmentId;

    private String comment;

    private Integer dptId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getTempBarcode() {
        return tempBarcode;
    }

    public void setTempBarcode(String tempBarcode) {
        this.tempBarcode = tempBarcode;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getContainerNo() {
        return containerNo;
    }

    public void setContainerNo(String containerNo) {
        this.containerNo = containerNo;
    }

    public String getGroundLabel() {
        return groundLabel;
    }

    public void setGroundLabel(String groundLabel) {
        this.groundLabel = groundLabel;
    }

    public Integer getConsolId() {
        return consolId;
    }

    public void setConsolId(Integer consolId) {
        this.consolId = consolId;
    }

    public Integer getPrint() {
        return print;
    }

    public void setPrint(Integer print) {
        this.print = print;
    }

    public Integer getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(Integer shipmentId) {
        this.shipmentId = shipmentId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
        sb.append(", status=").append(status);
        sb.append(", barcode=").append(barcode);
        sb.append(", tempBarcode=").append(tempBarcode);
        sb.append(", userId=").append(userId);
        sb.append(", createTime=").append(createTime);
        sb.append(", locationId=").append(locationId);
        sb.append(", containerNo=").append(containerNo);
        sb.append(", groundLabel=").append(groundLabel);
        sb.append(", consolId=").append(consolId);
        sb.append(", print=").append(print);
        sb.append(", shipmentId=").append(shipmentId);
        sb.append(", comment=").append(comment);
        sb.append(", dptId=").append(dptId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}