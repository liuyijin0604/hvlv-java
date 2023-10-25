package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AirFreightInvoiceReconciliation implements Serializable {
    private Integer id;

    private Integer supplierId;

    private Integer historyId;

    private String invoiceNo;

    private String awb;

    private Date date;

    private Date due;

    private Date eta;

    private Date etd;

    private Date created;

    private String cnee;

    private String cnor;

    private String origin;

    private String dest;

    private BigDecimal weight;

    private BigDecimal chargeWeight;

    private BigDecimal volume;

    private BigDecimal subtotal;

    private BigDecimal gst;

    private BigDecimal total;

    private String model;

    private Integer fid;

    /**
     * 0 - not matched yet
1 - matched successfully
 more than 1 - unmatched result details code


     *
     * @mbg.generated
     */
    private Byte matchedResult;

    private Integer op;

    private String meta;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public Integer getHistoryId() {
        return historyId;
    }

    public void setHistoryId(Integer historyId) {
        this.historyId = historyId;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getAwb() {
        return awb;
    }

    public void setAwb(String awb) {
        this.awb = awb;
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

    public Date getEta() {
        return eta;
    }

    public void setEta(Date eta) {
        this.eta = eta;
    }

    public Date getEtd() {
        return etd;
    }

    public void setEtd(Date etd) {
        this.etd = etd;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getCnee() {
        return cnee;
    }

    public void setCnee(String cnee) {
        this.cnee = cnee;
    }

    public String getCnor() {
        return cnor;
    }

    public void setCnor(String cnor) {
        this.cnor = cnor;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
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

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getGst() {
        return gst;
    }

    public void setGst(BigDecimal gst) {
        this.gst = gst;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Byte getMatchedResult() {
        return matchedResult;
    }

    public void setMatchedResult(Byte matchedResult) {
        this.matchedResult = matchedResult;
    }

    public Integer getOp() {
        return op;
    }

    public void setOp(Integer op) {
        this.op = op;
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
        sb.append(", supplierId=").append(supplierId);
        sb.append(", historyId=").append(historyId);
        sb.append(", invoiceNo=").append(invoiceNo);
        sb.append(", awb=").append(awb);
        sb.append(", date=").append(date);
        sb.append(", due=").append(due);
        sb.append(", eta=").append(eta);
        sb.append(", etd=").append(etd);
        sb.append(", created=").append(created);
        sb.append(", cnee=").append(cnee);
        sb.append(", cnor=").append(cnor);
        sb.append(", origin=").append(origin);
        sb.append(", dest=").append(dest);
        sb.append(", weight=").append(weight);
        sb.append(", chargeWeight=").append(chargeWeight);
        sb.append(", volume=").append(volume);
        sb.append(", subtotal=").append(subtotal);
        sb.append(", gst=").append(gst);
        sb.append(", total=").append(total);
        sb.append(", model=").append(model);
        sb.append(", fid=").append(fid);
        sb.append(", matchedResult=").append(matchedResult);
        sb.append(", op=").append(op);
        sb.append(", meta=").append(meta);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}