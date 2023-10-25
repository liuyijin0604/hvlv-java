package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;

public class HsPoc implements Serializable {
    private Integer id;

    private Integer hsid;

    private String poc;

    private Float price;

    private byte[] inactive;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHsid() {
        return hsid;
    }

    public void setHsid(Integer hsid) {
        this.hsid = hsid;
    }

    public String getPoc() {
        return poc;
    }

    public void setPoc(String poc) {
        this.poc = poc;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public byte[] getInactive() {
        return inactive;
    }

    public void setInactive(byte[] inactive) {
        this.inactive = inactive;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", hsid=").append(hsid);
        sb.append(", poc=").append(poc);
        sb.append(", price=").append(price);
        sb.append(", inactive=").append(inactive);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}