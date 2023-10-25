package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CargoBooking implements Serializable {
    private Integer id;

    private Date createDate;

    private Date bookingDate1;

    private Date bookingDate2;

    private Byte status;

    private String deliveryPeriod;

    private Integer orgId;

    private Integer shipmentId;

    private String bookingNumber;

    private Integer destination;

    private BigDecimal fee;

    private String ref;

    private Integer cargoProcessId;

    private Date confirmedDate;

    private String hbn;

    private String otherRef;

    private Integer depot;

    private String meta;

    private String comment;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getBookingDate1() {
        return bookingDate1;
    }

    public void setBookingDate1(Date bookingDate1) {
        this.bookingDate1 = bookingDate1;
    }

    public Date getBookingDate2() {
        return bookingDate2;
    }

    public void setBookingDate2(Date bookingDate2) {
        this.bookingDate2 = bookingDate2;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getDeliveryPeriod() {
        return deliveryPeriod;
    }

    public void setDeliveryPeriod(String deliveryPeriod) {
        this.deliveryPeriod = deliveryPeriod;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Integer getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(Integer shipmentId) {
        this.shipmentId = shipmentId;
    }

    public String getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(String bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    public Integer getDestination() {
        return destination;
    }

    public void setDestination(Integer destination) {
        this.destination = destination;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public Integer getCargoProcessId() {
        return cargoProcessId;
    }

    public void setCargoProcessId(Integer cargoProcessId) {
        this.cargoProcessId = cargoProcessId;
    }

    public Date getConfirmedDate() {
        return confirmedDate;
    }

    public void setConfirmedDate(Date confirmedDate) {
        this.confirmedDate = confirmedDate;
    }

    public String getHbn() {
        return hbn;
    }

    public void setHbn(String hbn) {
        this.hbn = hbn;
    }

    public String getOtherRef() {
        return otherRef;
    }

    public void setOtherRef(String otherRef) {
        this.otherRef = otherRef;
    }

    public Integer getDepot() {
        return depot;
    }

    public void setDepot(Integer depot) {
        this.depot = depot;
    }

    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", createDate=").append(createDate);
        sb.append(", bookingDate1=").append(bookingDate1);
        sb.append(", bookingDate2=").append(bookingDate2);
        sb.append(", status=").append(status);
        sb.append(", deliveryPeriod=").append(deliveryPeriod);
        sb.append(", orgId=").append(orgId);
        sb.append(", shipmentId=").append(shipmentId);
        sb.append(", bookingNumber=").append(bookingNumber);
        sb.append(", destination=").append(destination);
        sb.append(", fee=").append(fee);
        sb.append(", ref=").append(ref);
        sb.append(", cargoProcessId=").append(cargoProcessId);
        sb.append(", confirmedDate=").append(confirmedDate);
        sb.append(", hbn=").append(hbn);
        sb.append(", otherRef=").append(otherRef);
        sb.append(", depot=").append(depot);
        sb.append(", meta=").append(meta);
        sb.append(", comment=").append(comment);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}