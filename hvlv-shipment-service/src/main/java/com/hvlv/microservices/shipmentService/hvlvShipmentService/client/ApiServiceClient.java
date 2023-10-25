package com.hvlv.microservices.shipmentService.hvlvShipmentService.client;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.beans.JsonResultBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="hvlv-api-service")
public interface ApiServiceClient {

    @PostMapping("/api/createShipment")
    JsonResultBean createShipment(@RequestParam("data") String data);

    @PostMapping("/api/manifestShipment")
    JsonResultBean manifestShipment(@RequestParam("data") String data);

    @PostMapping("api/getAlliedCharge")
    JsonResultBean getAlliedCharge(@RequestParam("data") String data);
}
