package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;

public class HunterPortcode implements Serializable {
    private String suburb;

    private Integer postcode;

    private String portcode;

    private Integer zonecode;

    private static final long serialVersionUID = 1L;

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public Integer getPostcode() {
        return postcode;
    }

    public void setPostcode(Integer postcode) {
        this.postcode = postcode;
    }

    public String getPortcode() {
        return portcode;
    }

    public void setPortcode(String portcode) {
        this.portcode = portcode;
    }

    public Integer getZonecode() {
        return zonecode;
    }

    public void setZonecode(Integer zonecode) {
        this.zonecode = zonecode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", suburb=").append(suburb);
        sb.append(", postcode=").append(postcode);
        sb.append(", portcode=").append(portcode);
        sb.append(", zonecode=").append(zonecode);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}