package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;
import java.util.Date;

public class WmsStockLedger implements Serializable {
    private Integer id;

    private Integer tiId;

    private Integer taskId;

    private Integer stockId;

    private Integer locationId;

    private Integer l2Id;

    private Float qtyIn;

    private Float qtyOut;

    private Date ts;

    private Integer bwf;

    private String meta;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTiId() {
        return tiId;
    }

    public void setTiId(Integer tiId) {
        this.tiId = tiId;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Integer getStockId() {
        return stockId;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public Integer getL2Id() {
        return l2Id;
    }

    public void setL2Id(Integer l2Id) {
        this.l2Id = l2Id;
    }

    public Float getQtyIn() {
        return qtyIn;
    }

    public void setQtyIn(Float qtyIn) {
        this.qtyIn = qtyIn;
    }

    public Float getQtyOut() {
        return qtyOut;
    }

    public void setQtyOut(Float qtyOut) {
        this.qtyOut = qtyOut;
    }

    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }

    public Integer getBwf() {
        return bwf;
    }

    public void setBwf(Integer bwf) {
        this.bwf = bwf;
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
        sb.append(", tiId=").append(tiId);
        sb.append(", taskId=").append(taskId);
        sb.append(", stockId=").append(stockId);
        sb.append(", locationId=").append(locationId);
        sb.append(", l2Id=").append(l2Id);
        sb.append(", qtyIn=").append(qtyIn);
        sb.append(", qtyOut=").append(qtyOut);
        sb.append(", ts=").append(ts);
        sb.append(", bwf=").append(bwf);
        sb.append(", meta=").append(meta);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}