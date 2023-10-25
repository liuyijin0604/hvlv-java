package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;
import java.util.Date;

public class CargoProcess implements Serializable {
    public static final String FBAPOSTCODE = "'3175','2170','2143','2211','3029','2015','2142','6105','4178','3043','3023','2163','2178','2196','2114'";
    public static final String OVERSEAPOSTCODE = "'3175','2143','2211','3029','2015','2142','2163','2196','2114'";
    public static final int FBA_CARGO = 2;
    private Integer id;

    private Integer shipmentId;

    /**
     * 10:collect Info, 20: assign driver, 30:Paperwork,40:Waiting for delivery,100:Done
     *
     * @mbg.generated
     */
    private Integer status;

    private Date started;

    private Date date;

    private Integer driverId;

    private Byte cargoReceipt;

    private Integer gatePassId;

    private Integer aggPodId;

    /**
     * cargo_type:1 normal ,2 FBA cargo\n
     *
     * @mbg.generated
     */
    private Integer type;

    private String caref;

    private Integer subType;

    private Integer dptId;

    private Integer wasInterstate;

    private String note;

    private String meta;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    public Byte getCargoReceipt() {
        return cargoReceipt;
    }

    public void setCargoReceipt(Byte cargoReceipt) {
        this.cargoReceipt = cargoReceipt;
    }

    public Integer getGatePassId() {
        return gatePassId;
    }

    public void setGatePassId(Integer gatePassId) {
        this.gatePassId = gatePassId;
    }

    public Integer getAggPodId() {
        return aggPodId;
    }

    public void setAggPodId(Integer aggPodId) {
        this.aggPodId = aggPodId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCaref() {
        return caref;
    }

    public void setCaref(String caref) {
        this.caref = caref;
    }

    public Integer getSubType() {
        return subType;
    }

    public void setSubType(Integer subType) {
        this.subType = subType;
    }

    public Integer getDptId() {
        return dptId;
    }

    public void setDptId(Integer dptId) {
        this.dptId = dptId;
    }

    public Integer getWasInterstate() {
        return wasInterstate;
    }

    public void setWasInterstate(Integer wasInterstate) {
        this.wasInterstate = wasInterstate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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
        sb.append(", shipmentId=").append(shipmentId);
        sb.append(", status=").append(status);
        sb.append(", started=").append(started);
        sb.append(", date=").append(date);
        sb.append(", driverId=").append(driverId);
        sb.append(", cargoReceipt=").append(cargoReceipt);
        sb.append(", gatePassId=").append(gatePassId);
        sb.append(", aggPodId=").append(aggPodId);
        sb.append(", type=").append(type);
        sb.append(", caref=").append(caref);
        sb.append(", subType=").append(subType);
        sb.append(", dptId=").append(dptId);
        sb.append(", wasInterstate=").append(wasInterstate);
        sb.append(", note=").append(note);
        sb.append(", meta=").append(meta);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}