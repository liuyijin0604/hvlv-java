package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;
import java.util.Date;

public class ShipmentScan implements Serializable {
    private Integer id;

    private Integer userId;

    private Integer pid;

    /**
     * package number
     *
     * @mbg.generated
     */
    private Byte pno;

    private Integer warehouse;

    private byte[] type;

    private Date scanTime;

    private Integer pkg;

    private Float weight;

    private static final long serialVersionUID = 1L;

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

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Byte getPno() {
        return pno;
    }

    public void setPno(Byte pno) {
        this.pno = pno;
    }

    public Integer getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Integer warehouse) {
        this.warehouse = warehouse;
    }

    public byte[] getType() {
        return type;
    }

    public void setType(byte[] type) {
        this.type = type;
    }

    public Date getScanTime() {
        return scanTime;
    }

    public void setScanTime(Date scanTime) {
        this.scanTime = scanTime;
    }

    public Integer getPkg() {
        return pkg;
    }

    public void setPkg(Integer pkg) {
        this.pkg = pkg;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", pid=").append(pid);
        sb.append(", pno=").append(pno);
        sb.append(", warehouse=").append(warehouse);
        sb.append(", type=").append(type);
        sb.append(", scanTime=").append(scanTime);
        sb.append(", pkg=").append(pkg);
        sb.append(", weight=").append(weight);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}