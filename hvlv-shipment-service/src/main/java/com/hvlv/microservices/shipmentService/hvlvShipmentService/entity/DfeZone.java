package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;

public class DfeZone implements Serializable {
    private Integer id;

    private String postcode;

    private String postcodename;

    private String state;

    private String carrierzone;

    private String sortcode;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getPostcodename() {
        return postcodename;
    }

    public void setPostcodename(String postcodename) {
        this.postcodename = postcodename;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCarrierzone() {
        return carrierzone;
    }

    public void setCarrierzone(String carrierzone) {
        this.carrierzone = carrierzone;
    }

    public String getSortcode() {
        return sortcode;
    }

    public void setSortcode(String sortcode) {
        this.sortcode = sortcode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", postcode=").append(postcode);
        sb.append(", postcodename=").append(postcodename);
        sb.append(", state=").append(state);
        sb.append(", carrierzone=").append(carrierzone);
        sb.append(", sortcode=").append(sortcode);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}