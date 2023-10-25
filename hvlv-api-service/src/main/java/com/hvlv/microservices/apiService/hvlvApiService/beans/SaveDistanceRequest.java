package com.hvlv.microservices.apiService.hvlvApiService.beans;

public class SaveDistanceRequest {
    private ApiAddrBean addr;
    private Integer distance;

    // Constructors
    public SaveDistanceRequest() {
    }

    public SaveDistanceRequest(ApiAddrBean addr, Integer distance) {
        this.addr = addr;
        this.distance = distance;
    }

    // Getters and setters
    public ApiAddrBean getAddr() {
        return addr;
    }

    public void setAddr(ApiAddrBean addr) {
        this.addr = addr;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }
}

