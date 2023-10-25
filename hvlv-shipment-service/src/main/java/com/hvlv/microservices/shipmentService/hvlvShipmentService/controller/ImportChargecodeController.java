package com.hvlv.microservices.shipmentService.hvlvShipmentService.controller;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.beans.AddrBean;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.beans.JsonResultBean;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.beans.ShipmentBean;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.service.ImportChargecodeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class ImportChargecodeController {

    @Autowired
    Environment environment;
    @Autowired
    ImportChargecodeService importChargecodeService;

    @PostMapping("/importChargecode/hasChargeSetUp")
    public JsonResultBean hasChargeSetUp() {

        ShipmentBean shipment = new ShipmentBean();
        shipment.setChargecode("TSN3103013095");
        shipment.setCharge_wt(8.0);
        shipment.setWeight(8.2);
        shipment.setCbm(0.029970);
        shipment.setCharge_cbm(12.0);
        shipment.setCnee(1591114);
        shipment.setPkg(1);

        String chargecode ="9427";

        AddrBean cnee = new AddrBean();
        cnee.setId(1591114);
        cnee.setOwnerId(0);
        cnee.setCnidId(0);
        cnee.setName("Ayilian");
        cnee.setCompany("");
        cnee.setAddress("PO Box 9 ERMINGTON, NSW 1700");
        cnee.setSuburb("MELBOURNE");
        cnee.setCity("MELBOURNE");
        cnee.setState("VIC");
        cnee.setPostcode("8066");
        cnee.setCountry("Australia");
        cnee.setTel("447425900580");
        cnee.setEmail("");
        cnee.setAcc((byte) 0);
        cnee.setCnidNo("0");

        JsonResultBean result = importChargecodeService.hasChargeSetUp(shipment,chargecode,cnee);
        return result;
    }

    @PostMapping("/importChargecode/checkChargecodeCanDelivery")
    public JsonResultBean checkChargecodeCanDelivery() {

        ShipmentBean shipment = new ShipmentBean();
        shipment.setChargecode("3600");
        shipment.setCharge_wt(8.00);
        shipment.setWeight(8.00);
        shipment.setCbm(0.029970);
        shipment.setCharge_cbm(12.0);
        shipment.setPkg(1);
        shipment.setCurrency((byte) 1);
        shipment.setDvalue(new BigDecimal("1160.00"));
        shipment.setCref("SKP3103013095");
        shipment.setHbn("SKP3103013095");
        shipment.setCbwf(64);

        String chargecode ="9427";

        AddrBean cnee = new AddrBean();
        cnee.setId(1591114);
        cnee.setOwnerId(0);
        cnee.setCnidId(0);
        cnee.setName("Ayilian");
        cnee.setCompany("");
        cnee.setAddress("PO Box 9 ERMINGTON, NSW 1700");
        cnee.setSuburb("MELBOURNE");
        cnee.setCity("MELBOURNE");
        cnee.setState("VIC");
        cnee.setPostcode("8066");
        cnee.setCountry("Australia");
        cnee.setTel("447425900580");
        cnee.setEmail("");
        cnee.setAcc((byte) 0);
        cnee.setCnidNo("0");

        JsonResultBean result = importChargecodeService.checkChargecodeCanDeliveryservice(shipment,chargecode,cnee);
        return result;
    }

    @PostMapping("/importChargecode/checkPoboxAddressDelivebility")
    public JsonResultBean checkPoboxAddressDelivebility() {

        String chargecode ="9427";

        AddrBean cnee = new AddrBean();
        cnee.setId(1591114);
        cnee.setOwnerId(0);
        cnee.setCnidId(0);
        cnee.setName("Ayilian");
        cnee.setCompany("");
        cnee.setAddress("PO Box 9 ERMINGTON, NSW 1700");
        cnee.setSuburb("MELBOURNE");
        cnee.setCity("MELBOURNE");
        cnee.setState("VIC");
        cnee.setPostcode("9999");
        cnee.setCountry("Australia");
        cnee.setTel("447425900580");
        cnee.setEmail("");
        cnee.setAcc((byte) 0);
        cnee.setCnidNo("0");

        JsonResultBean result = importChargecodeService.checkPoboxAddressDelivebilityservice(chargecode,cnee);
        return result;
    }

}
