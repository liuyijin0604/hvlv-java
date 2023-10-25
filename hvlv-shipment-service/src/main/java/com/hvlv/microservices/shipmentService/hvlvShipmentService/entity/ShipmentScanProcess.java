package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;

public class ShipmentScanProcess implements Serializable {
    private Integer shipmentScanId;

    private Integer process;

    private String barcode;

    private static final long serialVersionUID = 1L;

    public Integer getShipmentScanId() {
        return shipmentScanId;
    }

    public void setShipmentScanId(Integer shipmentScanId) {
        this.shipmentScanId = shipmentScanId;
    }

    public Integer getProcess() {
        return process;
    }

    public void setProcess(Integer process) {
        this.process = process;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", shipmentScanId=").append(shipmentScanId);
        sb.append(", process=").append(process);
        sb.append(", barcode=").append(barcode);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}