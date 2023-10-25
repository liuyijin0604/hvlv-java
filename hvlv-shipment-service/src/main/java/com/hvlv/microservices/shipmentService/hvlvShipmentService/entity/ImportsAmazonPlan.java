package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;
import java.util.Date;

public class ImportsAmazonPlan implements Serializable {
    private Integer id;

    private Date amazonBookingTime;

    private String bookingRef;

    private Integer pallet;

    private Integer slot;

    private Integer userId;

    private Date create;

    private Integer dptId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getAmazonBookingTime() {
        return amazonBookingTime;
    }

    public void setAmazonBookingTime(Date amazonBookingTime) {
        this.amazonBookingTime = amazonBookingTime;
    }

    public String getBookingRef() {
        return bookingRef;
    }

    public void setBookingRef(String bookingRef) {
        this.bookingRef = bookingRef;
    }

    public Integer getPallet() {
        return pallet;
    }

    public void setPallet(Integer pallet) {
        this.pallet = pallet;
    }

    public Integer getSlot() {
        return slot;
    }

    public void setSlot(Integer slot) {
        this.slot = slot;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreate() {
        return create;
    }

    public void setCreate(Date create) {
        this.create = create;
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
        sb.append(", amazonBookingTime=").append(amazonBookingTime);
        sb.append(", bookingRef=").append(bookingRef);
        sb.append(", pallet=").append(pallet);
        sb.append(", slot=").append(slot);
        sb.append(", userId=").append(userId);
        sb.append(", create=").append(create);
        sb.append(", dptId=").append(dptId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}