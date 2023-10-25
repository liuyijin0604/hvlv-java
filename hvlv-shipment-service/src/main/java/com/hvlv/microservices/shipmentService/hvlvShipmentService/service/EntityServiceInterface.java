package com.hvlv.microservices.shipmentService.hvlvShipmentService.service;

public interface EntityServiceInterface<T> {
    public void setupAllRelations(T object);
}
