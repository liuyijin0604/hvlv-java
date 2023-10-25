package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;
import java.util.Date;

public class ShipmentRtsRecord implements Serializable {
    private Integer id;

    private Integer shipmentId;

    private String barcode;

    private Date recordTime;

    /**
     * 0:unknown 1 known
     *
     * @mbg.generated
     */
    private Integer type;

    private Integer sn;

    private String reason;

    private Integer adjustShipmentId;

    private Integer adjustSn;

    private Integer warehouseId;

    private Integer userId;

    private Integer isPrint;

    private Integer status;

    private Integer locationId;

    private Date discardTime;

    private Integer agentId;

    private Integer confirmId;

    private Integer isNotice;

    private Integer rtsInvoiceId;

    private Date unknownEditTime;

    private Integer discardUserId;

    private Date noticeTime;

    private Integer secondRts;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(Integer shipmentId) {
        this.shipmentId = shipmentId;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSn() {
        return sn;
    }

    public void setSn(Integer sn) {
        this.sn = sn;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getAdjustShipmentId() {
        return adjustShipmentId;
    }

    public void setAdjustShipmentId(Integer adjustShipmentId) {
        this.adjustShipmentId = adjustShipmentId;
    }

    public Integer getAdjustSn() {
        return adjustSn;
    }

    public void setAdjustSn(Integer adjustSn) {
        this.adjustSn = adjustSn;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getIsPrint() {
        return isPrint;
    }

    public void setIsPrint(Integer isPrint) {
        this.isPrint = isPrint;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public Date getDiscardTime() {
        return discardTime;
    }

    public void setDiscardTime(Date discardTime) {
        this.discardTime = discardTime;
    }

    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    public Integer getConfirmId() {
        return confirmId;
    }

    public void setConfirmId(Integer confirmId) {
        this.confirmId = confirmId;
    }

    public Integer getIsNotice() {
        return isNotice;
    }

    public void setIsNotice(Integer isNotice) {
        this.isNotice = isNotice;
    }

    public Integer getRtsInvoiceId() {
        return rtsInvoiceId;
    }

    public void setRtsInvoiceId(Integer rtsInvoiceId) {
        this.rtsInvoiceId = rtsInvoiceId;
    }

    public Date getUnknownEditTime() {
        return unknownEditTime;
    }

    public void setUnknownEditTime(Date unknownEditTime) {
        this.unknownEditTime = unknownEditTime;
    }

    public Integer getDiscardUserId() {
        return discardUserId;
    }

    public void setDiscardUserId(Integer discardUserId) {
        this.discardUserId = discardUserId;
    }

    public Date getNoticeTime() {
        return noticeTime;
    }

    public void setNoticeTime(Date noticeTime) {
        this.noticeTime = noticeTime;
    }

    public Integer getSecondRts() {
        return secondRts;
    }

    public void setSecondRts(Integer secondRts) {
        this.secondRts = secondRts;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", shipmentId=").append(shipmentId);
        sb.append(", barcode=").append(barcode);
        sb.append(", recordTime=").append(recordTime);
        sb.append(", type=").append(type);
        sb.append(", sn=").append(sn);
        sb.append(", reason=").append(reason);
        sb.append(", adjustShipmentId=").append(adjustShipmentId);
        sb.append(", adjustSn=").append(adjustSn);
        sb.append(", warehouseId=").append(warehouseId);
        sb.append(", userId=").append(userId);
        sb.append(", isPrint=").append(isPrint);
        sb.append(", status=").append(status);
        sb.append(", locationId=").append(locationId);
        sb.append(", discardTime=").append(discardTime);
        sb.append(", agentId=").append(agentId);
        sb.append(", confirmId=").append(confirmId);
        sb.append(", isNotice=").append(isNotice);
        sb.append(", rtsInvoiceId=").append(rtsInvoiceId);
        sb.append(", unknownEditTime=").append(unknownEditTime);
        sb.append(", discardUserId=").append(discardUserId);
        sb.append(", noticeTime=").append(noticeTime);
        sb.append(", secondRts=").append(secondRts);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}