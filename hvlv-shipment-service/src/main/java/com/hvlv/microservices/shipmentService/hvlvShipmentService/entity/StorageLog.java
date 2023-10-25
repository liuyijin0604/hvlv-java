package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;
import java.util.Date;

public class StorageLog implements Serializable {
    private Integer id;

    private Integer sid;

    private String model;

    private Integer fid;

    private Date inDt;

    private Date outDt;

    private byte[] ckd;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
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

    public Date getInDt() {
        return inDt;
    }

    public void setInDt(Date inDt) {
        this.inDt = inDt;
    }

    public Date getOutDt() {
        return outDt;
    }

    public void setOutDt(Date outDt) {
        this.outDt = outDt;
    }

    public byte[] getCkd() {
        return ckd;
    }

    public void setCkd(byte[] ckd) {
        this.ckd = ckd;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", sid=").append(sid);
        sb.append(", model=").append(model);
        sb.append(", fid=").append(fid);
        sb.append(", inDt=").append(inDt);
        sb.append(", outDt=").append(outDt);
        sb.append(", ckd=").append(ckd);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}