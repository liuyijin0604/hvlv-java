package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;
import java.util.Date;

public class GatepassShipment implements Serializable {
    private Integer id;

    private Integer fid;

    private Byte sno;

    private Integer courierId;

    private Integer shipmentStatus;

    private String connoteNo;

    private Integer warehouse;

    private Date scanTime;

    private Date gatePassTime;

    private Integer parentId;

    private Byte status;

    private Date canGatepassDate;

    private String meta;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Byte getSno() {
        return sno;
    }

    public void setSno(Byte sno) {
        this.sno = sno;
    }

    public Integer getCourierId() {
        return courierId;
    }

    public void setCourierId(Integer courierId) {
        this.courierId = courierId;
    }

    public Integer getShipmentStatus() {
        return shipmentStatus;
    }

    public void setShipmentStatus(Integer shipmentStatus) {
        this.shipmentStatus = shipmentStatus;
    }

    public String getConnoteNo() {
        return connoteNo;
    }

    public void setConnoteNo(String connoteNo) {
        this.connoteNo = connoteNo;
    }

    public Integer getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Integer warehouse) {
        this.warehouse = warehouse;
    }

    public Date getScanTime() {
        return scanTime;
    }

    public void setScanTime(Date scanTime) {
        this.scanTime = scanTime;
    }

    public Date getGatePassTime() {
        return gatePassTime;
    }

    public void setGatePassTime(Date gatePassTime) {
        this.gatePassTime = gatePassTime;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getCanGatepassDate() {
        return canGatepassDate;
    }

    public void setCanGatepassDate(Date canGatepassDate) {
        this.canGatepassDate = canGatepassDate;
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
        sb.append(", fid=").append(fid);
        sb.append(", sno=").append(sno);
        sb.append(", courierId=").append(courierId);
        sb.append(", shipmentStatus=").append(shipmentStatus);
        sb.append(", connoteNo=").append(connoteNo);
        sb.append(", warehouse=").append(warehouse);
        sb.append(", scanTime=").append(scanTime);
        sb.append(", gatePassTime=").append(gatePassTime);
        sb.append(", parentId=").append(parentId);
        sb.append(", status=").append(status);
        sb.append(", canGatepassDate=").append(canGatepassDate);
        sb.append(", meta=").append(meta);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}