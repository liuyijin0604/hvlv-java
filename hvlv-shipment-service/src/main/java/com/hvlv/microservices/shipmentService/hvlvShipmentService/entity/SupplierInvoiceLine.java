package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class SupplierInvoiceLine implements Serializable {
    private Integer id;

    private Integer invId;

    private String ref;

    private String itemCode;

    private String postcode;

    private BigDecimal amount;

    private BigDecimal gst;

    private String det;

    private Float weight;

    private BigDecimal qty;

    private BigDecimal amountExGst;

    private Float courierCubic;

    private Float cdeadwt;

    private String meta;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInvId() {
        return invId;
    }

    public void setInvId(Integer invId) {
        this.invId = invId;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getGst() {
        return gst;
    }

    public void setGst(BigDecimal gst) {
        this.gst = gst;
    }

    public String getDet() {
        return det;
    }

    public void setDet(String det) {
        this.det = det;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public BigDecimal getAmountExGst() {
        return amountExGst;
    }

    public void setAmountExGst(BigDecimal amountExGst) {
        this.amountExGst = amountExGst;
    }

    public Float getCourierCubic() {
        return courierCubic;
    }

    public void setCourierCubic(Float courierCubic) {
        this.courierCubic = courierCubic;
    }

    public Float getCdeadwt() {
        return cdeadwt;
    }

    public void setCdeadwt(Float cdeadwt) {
        this.cdeadwt = cdeadwt;
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
        sb.append(", invId=").append(invId);
        sb.append(", ref=").append(ref);
        sb.append(", itemCode=").append(itemCode);
        sb.append(", postcode=").append(postcode);
        sb.append(", amount=").append(amount);
        sb.append(", gst=").append(gst);
        sb.append(", det=").append(det);
        sb.append(", weight=").append(weight);
        sb.append(", qty=").append(qty);
        sb.append(", amountExGst=").append(amountExGst);
        sb.append(", courierCubic=").append(courierCubic);
        sb.append(", cdeadwt=").append(cdeadwt);
        sb.append(", meta=").append(meta);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}