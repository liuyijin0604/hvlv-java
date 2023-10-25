package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;

public class ShipmentFbaView implements Serializable {
    private Integer id;

    private String amazonPo;

    private String amazonShipmentIds;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAmazonPo() {
        return amazonPo;
    }

    public void setAmazonPo(String amazonPo) {
        this.amazonPo = amazonPo;
    }

    public String getAmazonShipmentIds() {
        return amazonShipmentIds;
    }

    public void setAmazonShipmentIds(String amazonShipmentIds) {
        this.amazonShipmentIds = amazonShipmentIds;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", amazonPo=").append(amazonPo);
        sb.append(", amazonShipmentIds=").append(amazonShipmentIds);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}