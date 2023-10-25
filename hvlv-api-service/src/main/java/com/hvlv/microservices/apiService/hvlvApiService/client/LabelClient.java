package com.hvlv.microservices.apiService.hvlvApiService.client;

import com.hvlv.microservices.apiService.hvlvApiService.beans.JsonResultBean;
import com.hvlv.microservices.apiService.hvlvApiService.beans.SaveDistanceRequest;
import com.hvlv.microservices.apiService.hvlvApiService.entity.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name="hvlv-shipment-service")
public interface LabelClient {

    @PostMapping("/label/generateRefByPrefix")
    JsonResultBean generateRefByPrefix(@RequestParam("data") String data);

    @PostMapping("/addr/getPostcodeDistance")
    PostcodeDistance getPostcodeDistance(@RequestParam("data") String data);

    @PostMapping("/addr/savePostcodeDistance")
    void savePostcodeDistance(@RequestBody SaveDistanceRequest request);

    @PostMapping("/orgRate/getOrgRate")
    OrgRate getOrgRate(@RequestParam("data") Integer data);

    @PostMapping("/parcelBarcode/getParcelBarcode")
    ParcelBarcode getParcelBarcode(@RequestParam("data")String data);

    @PostMapping("/zoneMap/getZoneMapFw")
    Integer getZoneMapFw(@RequestParam("data") Integer data);

    @PostMapping("/tranShip/getTranshipByShipmentId")
    List<Tranship> getTranshipByShipmentId(@RequestParam("data") Integer data);

    @PostMapping("/tranShip/updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(@RequestBody Tranship tranship);

    @PostMapping("/manifest/insert")
    int createManifest(@RequestBody Manifest manifest);

    @PostMapping("/manimap/insert")
    int insertManiMap(@RequestBody ManiMap manimap);

}
