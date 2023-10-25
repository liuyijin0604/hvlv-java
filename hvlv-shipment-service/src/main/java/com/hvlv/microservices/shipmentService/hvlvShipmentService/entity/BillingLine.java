package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BillingLine implements Serializable {
    private Integer id;

    private Integer billingId;

    private Integer orgId;

    /**
     * operator ID
     *
     * @mbg.generated
     */
    private Integer opId;

    /**
     * linked to the job line id
     *
     * @mbg.generated
     */
    private Integer linkId;

    /**
     * the client who use this cost
     *
     * @mbg.generated
     */
    private Integer toId;

    private Date created;

    private Date date;

    private Date due;

    private Date transactionDate;

    private Integer type;

    private Integer dpmt;

    private String gst;

    private Byte status;

    private String billingCref;

    private String billingRef;

    private String awb;

    private String desc;

    private Integer qty;

    private BigDecimal price;

    private Integer dptId;

    private byte[] currency;

    private String no;

    private BigDecimal actualAmount;

    private BigDecimal accrualAmount;

    private BigDecimal gstAmount;

    private String chargeCode;

    private BigDecimal weight;

    private BigDecimal chargeWeight;

    private String itemCode;

    private Byte syncXero;

    private Integer flag;

    private String meta;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBillingId() {
        return billingId;
    }

    public void setBillingId(Integer billingId) {
        this.billingId = billingId;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Integer getOpId() {
        return opId;
    }

    public void setOpId(Integer opId) {
        this.opId = opId;
    }

    public Integer getLinkId() {
        return linkId;
    }

    public void setLinkId(Integer linkId) {
        this.linkId = linkId;
    }

    public Integer getToId() {
        return toId;
    }

    public void setToId(Integer toId) {
        this.toId = toId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDue() {
        return due;
    }

    public void setDue(Date due) {
        this.due = due;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getBillingCref() {
        return billingCref;
    }

    public void setBillingCref(String billingCref) {
        this.billingCref = billingCref;
    }

    public String getBillingRef() {
        return billingRef;
    }

    public void setBillingRef(String billingRef) {
        this.billingRef = billingRef;
    }

    public String getAwb() {
        return awb;
    }

    public void setAwb(String awb) {
        this.awb = awb;
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

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
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

    public BigDecimal getGstAmount() {
        return gstAmount;
    }

    public void setGstAmount(BigDecimal gstAmount) {
        this.gstAmount = gstAmount;
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

    public BigDecimal getChargeWeight() {
        return chargeWeight;
    }

    public void setChargeWeight(BigDecimal chargeWeight) {
        this.chargeWeight = chargeWeight;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public Byte getSyncXero() {
        return syncXero;
    }

    public void setSyncXero(Byte syncXero) {
        this.syncXero = syncXero;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
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
        sb.append(", billingId=").append(billingId);
        sb.append(", orgId=").append(orgId);
        sb.append(", opId=").append(opId);
        sb.append(", linkId=").append(linkId);
        sb.append(", toId=").append(toId);
        sb.append(", created=").append(created);
        sb.append(", date=").append(date);
        sb.append(", due=").append(due);
        sb.append(", transactionDate=").append(transactionDate);
        sb.append(", type=").append(type);
        sb.append(", dpmt=").append(dpmt);
        sb.append(", gst=").append(gst);
        sb.append(", status=").append(status);
        sb.append(", billingCref=").append(billingCref);
        sb.append(", billingRef=").append(billingRef);
        sb.append(", awb=").append(awb);
        sb.append(", desc=").append(desc);
        sb.append(", qty=").append(qty);
        sb.append(", price=").append(price);
        sb.append(", dptId=").append(dptId);
        sb.append(", currency=").append(currency);
        sb.append(", no=").append(no);
        sb.append(", actualAmount=").append(actualAmount);
        sb.append(", accrualAmount=").append(accrualAmount);
        sb.append(", gstAmount=").append(gstAmount);
        sb.append(", chargeCode=").append(chargeCode);
        sb.append(", weight=").append(weight);
        sb.append(", chargeWeight=").append(chargeWeight);
        sb.append(", itemCode=").append(itemCode);
        sb.append(", syncXero=").append(syncXero);
        sb.append(", flag=").append(flag);
        sb.append(", meta=").append(meta);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}