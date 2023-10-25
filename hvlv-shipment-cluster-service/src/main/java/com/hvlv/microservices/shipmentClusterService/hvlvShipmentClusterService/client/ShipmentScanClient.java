package com.hvlv.microservices.shipmentClusterService.hvlvShipmentClusterService.client;

import com.hvlv.microservices.shipmentClusterService.hvlvShipmentClusterService.beans.JsonResultBean;
import com.hvlv.microservices.shipmentClusterService.hvlvShipmentClusterService.beans.UserBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name="hvlv-shipment-service")

public interface ShipmentScanClient {

    @PostMapping("/shipment/scan")
    public JsonResultBean scanShipment(@RequestParam("data") String data);

    @PostMapping("/shipment/recognize")
    public JsonResultBean recognize(@RequestParam("data") String data);

}
