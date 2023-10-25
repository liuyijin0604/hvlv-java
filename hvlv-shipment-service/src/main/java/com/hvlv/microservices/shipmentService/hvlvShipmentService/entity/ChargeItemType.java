package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;

public class ChargeItemType implements Serializable {
    private Integer id;

    private String code;

    private String name;

    private String chargeCode;

    private Byte status;

    private String costCode;

    private String plChargeCode;

    private String plCostCode;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChargeCode() {
        return chargeCode;
    }

    public void setChargeCode(String chargeCode) {
        this.chargeCode = chargeCode;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getCostCode() {
        return costCode;
    }

    public void setCostCode(String costCode) {
        this.costCode = costCode;
    }

    public String getPlChargeCode() {
        return plChargeCode;
    }

    public void setPlChargeCode(String plChargeCode) {
        this.plChargeCode = plChargeCode;
    }

    public String getPlCostCode() {
        return plCostCode;
    }

    public void setPlCostCode(String plCostCode) {
        this.plCostCode = plCostCode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", code=").append(code);
        sb.append(", name=").append(name);
        sb.append(", chargeCode=").append(chargeCode);
        sb.append(", status=").append(status);
        sb.append(", costCode=").append(costCode);
        sb.append(", plChargeCode=").append(plChargeCode);
        sb.append(", plCostCode=").append(plCostCode);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}