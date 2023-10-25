package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;

public class ImportBagTag implements Serializable {
    private Integer id;

    private Integer shipmentId;

    private String bagTag;

    private Integer importBagId;

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

    public String getBagTag() {
        return bagTag;
    }

    public void setBagTag(String bagTag) {
        this.bagTag = bagTag;
    }

    public Integer getImportBagId() {
        return importBagId;
    }

    public void setImportBagId(Integer importBagId) {
        this.importBagId = importBagId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", shipmentId=").append(shipmentId);
        sb.append(", bagTag=").append(bagTag);
        sb.append(", importBagId=").append(importBagId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}