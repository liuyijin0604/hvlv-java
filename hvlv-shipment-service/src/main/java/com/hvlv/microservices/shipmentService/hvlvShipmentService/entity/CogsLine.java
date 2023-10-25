package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CogsLine implements Serializable {
    private Integer id;

    private Integer type;

    private String chargeCode;

    private Byte status;

    /**
     * Supplier
     *
     * @mbg.generated
     */
    private Integer orgId;

    /**
     * operator ID
     *
     * @mbg.generated
     */
    private Integer fid;

    private String model;

    private Date created;

    private Integer dpmt;

    private String gst;

    private String desc;

    private Integer qty;

    private BigDecimal price;

    private Integer dptId;

    private byte[] currency;

    private BigDecimal actualAmount;

    private BigDecimal accrualAmount;

    private BigDecimal accrualGstAmount;

    private BigDecimal actualGstAmount;

    private String itemCode;

    private String meta;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
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

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Integer getDpmt() {
        return dpmt;
    }

    public void setDpmt(Integer dpmt) {
        this.dpmt = dpmt;
    }

    public String getGst() {
        return gst;
    }

    public void setGst(String gst) {
        this.gst = gst;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getDptId() {
        return dptId;
    }

    public void setDptId(Integer dptId) {
        this.dptId = dptId;
    }

    public byte[] getCurrency() {
        return currency;
    }

    public void setCurrency(byte[] currency) {
        this.currency = currency;
    }

    public BigDecimal getActualAmount() {
        return actualAmount;
    }

    public void setActualAmount(BigDecimal actualAmount) {
        this.actualAmount = actualAmount;
    }

    public BigDecimal getAccrualAmount() {
        return accrualAmount;
    }

    public void setAccrualAmount(BigDecimal accrualAmount) {
        this.accrualAmount = accrualAmount;
    }

    public BigDecimal getAccrualGstAmount() {
        return accrualGstAmount;
    }

    public void setAccrualGstAmount(BigDecimal accrualGstAmount) {
        this.accrualGstAmount = accrualGstAmount;
    }

    public BigDecimal getActualGstAmount() {
        return actualGstAmount;
    }

    public void setActualGstAmount(BigDecimal actualGstAmount) {
        this.actualGstAmount = actualGstAmount;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
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
        sb.append(", type=").append(type);
        sb.append(", chargeCode=").append(chargeCode);
        sb.append(", status=").append(status);
        sb.append(", orgId=").append(orgId);
        sb.append(", fid=").append(fid);
        sb.append(", model=").append(model);
        sb.append(", created=").append(created);
        sb.append(", dpmt=").append(dpmt);
        sb.append(", gst=").append(gst);
        sb.append(", desc=").append(desc);
        sb.append(", qty=").append(qty);
        sb.append(", price=").append(price);
        sb.append(", dptId=").append(dptId);
        sb.append(", currency=").append(currency);
        sb.append(", actualAmount=").append(actualAmount);
        sb.append(", accrualAmount=").append(accrualAmount);
        sb.append(", accrualGstAmount=").append(accrualGstAmount);
        sb.append(", actualGstAmount=").append(actualGstAmount);
        sb.append(", itemCode=").append(itemCode);
        sb.append(", meta=").append(meta);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}