package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;
import java.util.Date;

public class CargoDeliveryInfo implements Serializable {
    private Integer id;

    private Integer shipmentId;

    private Date deliveryBookingTime;

    private String model;

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

    public Date getDeliveryBookingTime() {
        return deliveryBookingTime;
    }

    public void setDeliveryBookingTime(Date deliveryBookingTime) {
        this.deliveryBookingTime = deliveryBookingTime;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", shipmentId=").append(shipmentId);
        sb.append(", deliveryBookingTime=").append(deliveryBookingTime);
        sb.append(", model=").append(model);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}