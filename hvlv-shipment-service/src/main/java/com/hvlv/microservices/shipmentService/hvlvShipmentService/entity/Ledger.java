package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Ledger implements Serializable {
    private Integer id;

    private Integer fromId;

    private Integer toId;

    private Integer cra;

    private Integer dea;

    private Integer fid;

    private String model;

    private Byte type;

    private String chgcode;

    private Byte currency;

    private Byte status;

    private String no;

    private String ref;

    private Date date;

    private Date due;

    private BigDecimal total;

    private Integer bwf;

    private String lines;

    private String meta;

    private String notes;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFromId() {
        return fromId;
    }

    public void setFromId(Integer fromId) {
        this.fromId = fromId;
    }

    public Integer getToId() {
        return toId;
    }

    public void setToId(Integer toId) {
        this.toId = toId;
    }

    public Integer getCra() {
        return cra;
    }

    public void setCra(Integer cra) {
        this.cra = cra;
    }

    public Integer getDea() {
        return dea;
    }

    public void setDea(Integer dea) {
        this.dea = dea;
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

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getChgcode() {
        return chgcode;
    }

    public void setChgcode(String chgcode) {
        this.chgcode = chgcode;
    }

    public Byte getCurrency() {
        return currency;
    }

    public void setCurrency(Byte currency) {
        this.currency = currency;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
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

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Integer getBwf() {
        return bwf;
    }

    public void setBwf(Integer bwf) {
        this.bwf = bwf;
    }

    public String getLines() {
        return lines;
    }

    public void setLines(String lines) {
        this.lines = lines;
    }

    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", fromId=").append(fromId);
        sb.append(", toId=").append(toId);
        sb.append(", cra=").append(cra);
        sb.append(", dea=").append(dea);
        sb.append(", fid=").append(fid);
        sb.append(", model=").append(model);
        sb.append(", type=").append(type);
        sb.append(", chgcode=").append(chgcode);
        sb.append(", currency=").append(currency);
        sb.append(", status=").append(status);
        sb.append(", no=").append(no);
        sb.append(", ref=").append(ref);
        sb.append(", date=").append(date);
        sb.append(", due=").append(due);
        sb.append(", total=").append(total);
        sb.append(", bwf=").append(bwf);
        sb.append(", lines=").append(lines);
        sb.append(", meta=").append(meta);
        sb.append(", notes=").append(notes);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}