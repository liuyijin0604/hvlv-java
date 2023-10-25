package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;
import java.util.Date;

public class PoliHistory implements Serializable {
    private Integer id;

    private Integer invoiceId;

    /**
     * POLI transaction ID
     *
     * @mbg.generated
     */
    private String poliTrn;

    /**
     * POLI encripted transaction ID
     *
     * @mbg.generated
     */
    private String poliToken;

    private Date payedTime;

    private Date createTime;

    /**
     * payment result from POLI
     *
     * @mbg.generated
     */
    private String result;

    private String meta;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getPoliTrn() {
        return poliTrn;
    }

    public void setPoliTrn(String poliTrn) {
        this.poliTrn = poliTrn;
    }

    public String getPoliToken() {
        return poliToken;
    }

    public void setPoliToken(String poliToken) {
        this.poliToken = poliToken;
    }

    public Date getPayedTime() {
        return payedTime;
    }

    public void setPayedTime(Date payedTime) {
        this.payedTime = payedTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
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
        sb.append(", invoiceId=").append(invoiceId);
        sb.append(", poliTrn=").append(poliTrn);
        sb.append(", poliToken=").append(poliToken);
        sb.append(", payedTime=").append(payedTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", result=").append(result);
        sb.append(", meta=").append(meta);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}