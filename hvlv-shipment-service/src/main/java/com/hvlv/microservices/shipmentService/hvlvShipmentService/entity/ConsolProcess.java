package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;
import java.util.Date;

public class ConsolProcess implements Serializable {
    private Integer id;

    private Integer fid;

    private byte[] type;

    private Byte mainType;

    private Integer status;

    private Date started;

    private Date toWarehouse;

    private Date date;

    private String airport;

    private Date pickDeadDate;

    private Integer subStatus;

    private Integer subStatusIgnore;

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

    public byte[] getType() {
        return type;
    }

    public void setType(byte[] type) {
        this.type = type;
    }

    public Byte getMainType() {
        return mainType;
    }

    public void setMainType(Byte mainType) {
        this.mainType = mainType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getStarted() {
        return started;
    }

    public void setStarted(Date started) {
        this.started = started;
    }

    public Date getToWarehouse() {
        return toWarehouse;
    }

    public void setToWarehouse(Date toWarehouse) {
        this.toWarehouse = toWarehouse;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAirport() {
        return airport;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }

    public Date getPickDeadDate() {
        return pickDeadDate;
    }

    public void setPickDeadDate(Date pickDeadDate) {
        this.pickDeadDate = pickDeadDate;
    }

    public Integer getSubStatus() {
        return subStatus;
    }

    public void setSubStatus(Integer subStatus) {
        this.subStatus = subStatus;
    }

    public Integer getSubStatusIgnore() {
        return subStatusIgnore;
    }

    public void setSubStatusIgnore(Integer subStatusIgnore) {
        this.subStatusIgnore = subStatusIgnore;
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
        sb.append(", type=").append(type);
        sb.append(", mainType=").append(mainType);
        sb.append(", status=").append(status);
        sb.append(", started=").append(started);
        sb.append(", toWarehouse=").append(toWarehouse);
        sb.append(", date=").append(date);
        sb.append(", airport=").append(airport);
        sb.append(", pickDeadDate=").append(pickDeadDate);
        sb.append(", subStatus=").append(subStatus);
        sb.append(", subStatusIgnore=").append(subStatusIgnore);
        sb.append(", meta=").append(meta);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}