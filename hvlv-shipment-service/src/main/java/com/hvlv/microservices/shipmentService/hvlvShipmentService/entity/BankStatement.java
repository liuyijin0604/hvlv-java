package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BankStatement implements Serializable {
    private Integer id;

    private Integer bankAccountId;

    /**
     * currency type:
1 => 'AUD',
		2 => 'USD',
		3 => 'RMB',
		4 => 'HKD',
		5 => 'EUR',
		6 => 'GBP',
     *
     * @mbg.generated
     */
    private Byte currency;

    private Date created;

    private String desc;

    private BigDecimal debits;

    private BigDecimal credits;

    private BigDecimal balance;

    private Integer orgId;

    private Byte reconciled;

    private Date reconciledDate;

    private String hash;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(Integer bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public Byte getCurrency() {
        return currency;
    }

    public void setCurrency(Byte currency) {
        this.currency = currency;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public BigDecimal getDebits() {
        return debits;
    }

    public void setDebits(BigDecimal debits) {
        this.debits = debits;
    }

    public BigDecimal getCredits() {
        return credits;
    }

    public void setCredits(BigDecimal credits) {
        this.credits = credits;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Byte getReconciled() {
        return reconciled;
    }

    public void setReconciled(Byte reconciled) {
        this.reconciled = reconciled;
    }

    public Date getReconciledDate() {
        return reconciledDate;
    }

    public void setReconciledDate(Date reconciledDate) {
        this.reconciledDate = reconciledDate;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", bankAccountId=").append(bankAccountId);
        sb.append(", currency=").append(currency);
        sb.append(", created=").append(created);
        sb.append(", desc=").append(desc);
        sb.append(", debits=").append(debits);
        sb.append(", credits=").append(credits);
        sb.append(", balance=").append(balance);
        sb.append(", orgId=").append(orgId);
        sb.append(", reconciled=").append(reconciled);
        sb.append(", reconciledDate=").append(reconciledDate);
        sb.append(", hash=").append(hash);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}