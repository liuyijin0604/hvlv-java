package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;

public class BorderRouteCode implements Serializable {
    private String suburb;

    private String state;

    private String postcode;

    private String routeCode;

    private static final long serialVersionUID = 1L;

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getRouteCode() {
        return routeCode;
    }

    public void setRouteCode(String routeCode) {
        this.routeCode = routeCode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", suburb=").append(suburb);
        sb.append(", state=").append(state);
        sb.append(", postcode=").append(postcode);
        sb.append(", routeCode=").append(routeCode);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}