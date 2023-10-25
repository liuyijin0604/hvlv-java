package com.hvlv.microservices.shipmentService.hvlvShipmentService.beans;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.Shipment;

import java.util.List;

public class ShipmentScanBean {
    Integer type ;// 0 means single shipment,1 means bag
    Integer sn;
    Integer courierId;
    boolean changeLabel;
    List<Shipment> shipments;

    public ShipmentScanBean(Integer type, List<Shipment> shipments) {
        this.type = type;
        this.shipments = shipments;
        this.sn =0;
        this.courierId = 0;
    }

    public ShipmentScanBean(Integer type, Integer sn, List<Shipment> shipments) {
        this.type = type;
        this.shipments = shipments;
        this.sn =sn;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public List<Shipment> getShipments() {
        return shipments;
    }

    public void setShipments(List<Shipment> shipments) {
        this.shipments = shipments;
    }

    public Integer getSn() {
        return sn;
    }

    public void setSn(Integer sn) {
        this.sn = sn;
    }

    public Integer getCourierId() {
        return courierId;
    }

    public void setCourierId(Integer courierId) {
        this.courierId = courierId;
    }

    public boolean isChangeLabel() {
        return changeLabel;
    }

    public void setChangeLabel(boolean changeLabel) {
        this.changeLabel = changeLabel;
    }
}
