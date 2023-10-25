package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;
import java.util.Date;

public class ShipmentScanMqProcess implements Serializable {
    private Integer id;

    private Integer userId;

    private String barcode;

    private Integer pid;

    private Integer pno;

    private Integer warehouse;

    private Integer type;

    private String scanTime;

    private static final long serialVersionUID = 1L;

    public ShipmentScanMqProcess(Integer userId, String barcode, Integer id, Integer sn, Integer warehouse, Integer scanType, String scanTime) {
        this.id = id;
        this.userId = userId;
        this.barcode = barcode;
        this.pid = pid;
        this.pno = pno;
        this.warehouse = warehouse;
        this.type = type;
        this.scanTime = scanTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getPno() {
        return pno;
    }

    public void setPno(Integer pno) {
        this.pno = pno;
    }

    public Integer getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Integer warehouse) {
        this.warehouse = warehouse;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getScanTime() {
        return scanTime;
    }

    public void setScanTime(String scanTime) {
        this.scanTime = scanTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", barcode=").append(barcode);
        sb.append(", pid=").append(pid);
        sb.append(", pno=").append(pno);
        sb.append(", warehouse=").append(warehouse);
        sb.append(", type=").append(type);
        sb.append(", scanTime=").append(scanTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}