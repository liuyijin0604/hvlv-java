package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class ReconciliationLineDeclare implements Serializable {
    private Integer id;

    private Integer parentId;

    private Integer consolId;

    private Integer shipmentId;

    private String shipmentNo;

    private Float cdeadwt;

    private BigDecimal weight;

    private Float courierCubic;

    private Float custCheckWeight;

    private Float ourChargeWeight;

    private Float manifestWeight;

    private BigDecimal value;

    private BigDecimal myValue;

    private Float myValueM;

    private Float myCharge;

    private String invoiceNo;

    private String postcode;

    private Float csChargeWeight;

    private Float weightDiff;

    private Float orgChargeWeight;

    private Integer clientType;

    private String meta;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getConsolId() {
        return consolId;
    }

    public void setConsolId(Integer consolId) {
        this.consolId = consolId;
    }

    public Integer getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(Integer shipmentId) {
        this.shipmentId = shipmentId;
    }

    public String getShipmentNo() {
        return shipmentNo;
    }

    public void setShipmentNo(String shipmentNo) {
        this.shipmentNo = shipmentNo;
    }

    public Float getCdeadwt() {
        return cdeadwt;
    }

    public void setCdeadwt(Float cdeadwt) {
        this.cdeadwt = cdeadwt;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public Float getCourierCubic() {
        return courierCubic;
    }

    public void setCourierCubic(Float courierCubic) {
        this.courierCubic = courierCubic;
    }

    public Float getCustCheckWeight() {
        return custCheckWeight;
    }

    public void setCustCheckWeight(Float custCheckWeight) {
        this.custCheckWeight = custCheckWeight;
    }

    public Float getOurChargeWeight() {
        return ourChargeWeight;
    }

    public void setOurChargeWeight(Float ourChargeWeight) {
        this.ourChargeWeight = ourChargeWeight;
    }

    public Float getManifestWeight() {
        return manifestWeight;
    }

    public void setManifestWeight(Float manifestWeight) {
        this.manifestWeight = manifestWeight;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getMyValue() {
        return myValue;
    }

    public void setMyValue(BigDecimal myValue) {
        this.myValue = myValue;
    }

    public Float getMyValueM() {
        return myValueM;
    }

    public void setMyValueM(Float myValueM) {
        this.myValueM = myValueM;
    }

    public Float getMyCharge() {
        return myCharge;
    }

    public void setMyCharge(Float myCharge) {
        this.myCharge = myCharge;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public Float getCsChargeWeight() {
        return csChargeWeight;
    }

    public void setCsChargeWeight(Float csChargeWeight) {
        this.csChargeWeight = csChargeWeight;
    }

    public Float getWeightDiff() {
        return weightDiff;
    }

    public void setWeightDiff(Float weightDiff) {
        this.weightDiff = weightDiff;
    }

    public Float getOrgChargeWeight() {
        return orgChargeWeight;
    }

    public void setOrgChargeWeight(Float orgChargeWeight) {
        this.orgChargeWeight = orgChargeWeight;
    }

    public Integer getClientType() {
        return clientType;
    }

    public void setClientType(Integer clientType) {
        this.clientType = clientType;
    }

    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", parentId=").append(parentId);
        sb.append(", consolId=").append(consolId);
        sb.append(", shipmentId=").append(shipmentId);
        sb.append(", shipmentNo=").append(shipmentNo);
        sb.append(", cdeadwt=").append(cdeadwt);
        sb.append(", weight=").append(weight);
        sb.append(", courierCubic=").append(courierCubic);
        sb.append(", custCheckWeight=").append(custCheckWeight);
        sb.append(", ourChargeWeight=").append(ourChargeWeight);
        sb.append(", manifestWeight=").append(manifestWeight);
        sb.append(", value=").append(value);
        sb.append(", myValue=").append(myValue);
        sb.append(", myValueM=").append(myValueM);
        sb.append(", myCharge=").append(myCharge);
        sb.append(", invoiceNo=").append(invoiceNo);
        sb.append(", postcode=").append(postcode);
        sb.append(", csChargeWeight=").append(csChargeWeight);
        sb.append(", weightDiff=").append(weightDiff);
        sb.append(", orgChargeWeight=").append(orgChargeWeight);
        sb.append(", clientType=").append(clientType);
        sb.append(", meta=").append(meta);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}