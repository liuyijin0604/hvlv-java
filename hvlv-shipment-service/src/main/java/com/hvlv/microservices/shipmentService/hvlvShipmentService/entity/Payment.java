package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Payment implements Serializable {
    private Integer id;

    private String no;

    private Integer orgId;

    private Integer opId;

    private Byte dpmt;

    private Date date;

    private Date transactionDate;

    private byte[] status;

    private Integer bank;

    private byte[] currency;

    private BigDecimal amount;

    private BigDecimal ata;

    private BigDecimal refund;

    private byte[] type;

    private String ref;

    private Integer flag;

    private String xeroId;

    private Integer bankTransactionId;

    private String note;

    private String meta;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
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

    public Byte getDpmt() {
        return dpmt;
    }

    public void setDpmt(Byte dpmt) {
        this.dpmt = dpmt;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public byte[] getStatus() {
        return status;
    }

    public void setStatus(byte[] status) {
        this.status = status;
    }

    public Integer getBank() {
        return bank;
    }

    public void setBank(Integer bank) {
        this.bank = bank;
    }

    public byte[] getCurrency() {
        return currency;
    }

    public void setCurrency(byte[] currency) {
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAta() {
        return ata;
    }

    public void setAta(BigDecimal ata) {
        this.ata = ata;
    }

    public BigDecimal getRefund() {
        return refund;
    }

    public void setRefund(BigDecimal refund) {
        this.refund = refund;
    }

    public byte[] getType() {
        return type;
    }

    public void setType(byte[] type) {
        this.type = type;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getXeroId() {
        return xeroId;
    }

    public void setXeroId(String xeroId) {
        this.xeroId = xeroId;
    }

    public Integer getBankTransactionId() {
        return bankTransactionId;
    }

    public void setBankTransactionId(Integer bankTransactionId) {
        this.bankTransactionId = bankTransactionId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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
        sb.append(", no=").append(no);
        sb.append(", orgId=").append(orgId);
        sb.append(", opId=").append(opId);
        sb.append(", dpmt=").append(dpmt);
        sb.append(", date=").append(date);
        sb.append(", transactionDate=").append(transactionDate);
        sb.append(", status=").append(status);
        sb.append(", bank=").append(bank);
        sb.append(", currency=").append(currency);
        sb.append(", amount=").append(amount);
        sb.append(", ata=").append(ata);
        sb.append(", refund=").append(refund);
        sb.append(", type=").append(type);
        sb.append(", ref=").append(ref);
        sb.append(", flag=").append(flag);
        sb.append(", xeroId=").append(xeroId);
        sb.append(", bankTransactionId=").append(bankTransactionId);
        sb.append(", note=").append(note);
        sb.append(", meta=").append(meta);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}