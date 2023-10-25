package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;

public class SmsNotice implements Serializable {
    private Integer id;

    private String phone;

    private byte[] isProcessed;

    private Integer cargoProcessId;

    private String message;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public byte[] getIsProcessed() {
        return isProcessed;
    }

    public void setIsProcessed(byte[] isProcessed) {
        this.isProcessed = isProcessed;
    }

    public Integer getCargoProcessId() {
        return cargoProcessId;
    }

    public void setCargoProcessId(Integer cargoProcessId) {
        this.cargoProcessId = cargoProcessId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", phone=").append(phone);
        sb.append(", isProcessed=").append(isProcessed);
        sb.append(", cargoProcessId=").append(cargoProcessId);
        sb.append(", message=").append(message);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}