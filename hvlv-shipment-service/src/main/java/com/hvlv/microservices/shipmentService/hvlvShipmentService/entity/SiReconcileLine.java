package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class SiReconcileLine implements Serializable {
    private Integer id;

    private Integer recId;

    private String ref;

    private Integer type;

    private Integer fid;

    private String model;

    private String chargeCode;

    private BigDecimal weight;

    private Float courierCubic;

    private Float custCheckWeight;

    private Float ourChargeWeight;

    private Float manifestWeight;

    private BigDecimal value;

    private BigDecimal myValue;

    /**
     * this value is for the cost calcualted by the manifest_weight of our system and the rate of our system
     *
     * @mbg.generated
     */
    private BigDecimal myValueM;

    private BigDecimal myCharge;

    private String postcode;

    private Integer agentId;

    private Float csChargeWeight;

    private Float weightDiff;

    private Float orgChargeWeight;

    /**
     * 1: 2: Rate check 4:surcharge check
     *
     * @mbg.generated
     */
    private Integer confirmStatus;

    private Float cdeadwt;

    private String itemCode;

    private Integer inlinePid;

    private BigDecimal apiValue;

    private String det;

    private BigDecimal diff;

    private String meta;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRecId() {
        return recId;
    }

    public void setRecId(Integer recId) {
        this.recId = recId;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getChargeCode() {
        return chargeCode;
    }

    public void setChargeCode(String chargeCode) {
        this.chargeCode = chargeCode;
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

    public BigDecimal getMyValueM() {
        return myValueM;
    }

    public void setMyValueM(BigDecimal myValueM) {
        this.myValueM = myValueM;
    }

    public BigDecimal getMyCharge() {
        return myCharge;
    }

    public void setMyCharge(BigDecimal myCharge) {
        this.myCharge = myCharge;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
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

    public Integer getConfirmStatus() {
        return confirmStatus;
    }

    public void setConfirmStatus(Integer confirmStatus) {
        this.confirmStatus = confirmStatus;
    }

    public Float getCdeadwt() {
        return cdeadwt;
    }

    public void setCdeadwt(Float cdeadwt) {
        this.cdeadwt = cdeadwt;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public Integer getInlinePid() {
        return inlinePid;
    }

    public void setInlinePid(Integer inlinePid) {
        this.inlinePid = inlinePid;
    }

    public BigDecimal getApiValue() {
        return apiValue;
    }

    public void setApiValue(BigDecimal apiValue) {
        this.apiValue = apiValue;
    }

    public String getDet() {
        return det;
    }

    public void setDet(String det) {
        this.det = det;
    }

    public BigDecimal getDiff() {
        return diff;
    }

    public void setDiff(BigDecimal diff) {
        this.diff = diff;
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
        sb.append(", recId=").append(recId);
        sb.append(", ref=").append(ref);
        sb.append(", type=").append(type);
        sb.append(", fid=").append(fid);
        sb.append(", model=").append(model);
        sb.append(", chargeCode=").append(chargeCode);
        sb.append(", weight=").append(weight);
        sb.append(", courierCubic=").append(courierCubic);
        sb.append(", custCheckWeight=").append(custCheckWeight);
        sb.append(", ourChargeWeight=").append(ourChargeWeight);
        sb.append(", manifestWeight=").append(manifestWeight);
        sb.append(", value=").append(value);
        sb.append(", myValue=").append(myValue);
        sb.append(", myValueM=").append(myValueM);
        sb.append(", myCharge=").append(myCharge);
        sb.append(", postcode=").append(postcode);
        sb.append(", agentId=").append(agentId);
        sb.append(", csChargeWeight=").append(csChargeWeight);
        sb.append(", weightDiff=").append(weightDiff);
        sb.append(", orgChargeWeight=").append(orgChargeWeight);
        sb.append(", confirmStatus=").append(confirmStatus);
        sb.append(", cdeadwt=").append(cdeadwt);
        sb.append(", itemCode=").append(itemCode);
        sb.append(", inlinePid=").append(inlinePid);
        sb.append(", apiValue=").append(apiValue);
        sb.append(", det=").append(det);
        sb.append(", diff=").append(diff);
        sb.append(", meta=").append(meta);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}