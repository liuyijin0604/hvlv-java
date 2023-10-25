package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;
import java.util.Date;

public class ShipmentUpdate implements Serializable {
    private Integer id;

    private Integer shipmentId;

    private Integer type;

    private Date created;

    private Integer numValue;

    private String textValue;

    private Integer oNumValue;

    private String oTextValue;

    private Integer status;

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Integer getNumValue() {
        return numValue;
    }

    public void setNumValue(Integer numValue) {
        this.numValue = numValue;
    }

    public String getTextValue() {
        return textValue;
    }

    public void setTextValue(String textValue) {
        this.textValue = textValue;
    }

    public Integer getoNumValue() {
        return oNumValue;
    }

    public void setoNumValue(Integer oNumValue) {
        this.oNumValue = oNumValue;
    }

    public String getoTextValue() {
        return oTextValue;
    }

    public void setoTextValue(String oTextValue) {
        this.oTextValue = oTextValue;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", shipmentId=").append(shipmentId);
        sb.append(", type=").append(type);
        sb.append(", created=").append(created);
        sb.append(", numValue=").append(numValue);
        sb.append(", textValue=").append(textValue);
        sb.append(", oNumValue=").append(oNumValue);
        sb.append(", oTextValue=").append(oTextValue);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}