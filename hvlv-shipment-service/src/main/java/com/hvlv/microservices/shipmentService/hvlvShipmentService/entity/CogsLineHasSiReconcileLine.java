package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;

public class CogsLineHasSiReconcileLine implements Serializable {
    private Integer cogsLineId;

    private Integer siReconcileLineId;

    private static final long serialVersionUID = 1L;

    public Integer getCogsLineId() {
        return cogsLineId;
    }

    public void setCogsLineId(Integer cogsLineId) {
        this.cogsLineId = cogsLineId;
    }

    public Integer getSiReconcileLineId() {
        return siReconcileLineId;
    }

    public void setSiReconcileLineId(Integer siReconcileLineId) {
        this.siReconcileLineId = siReconcileLineId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cogsLineId=").append(cogsLineId);
        sb.append(", siReconcileLineId=").append(siReconcileLineId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}