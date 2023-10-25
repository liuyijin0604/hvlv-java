package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;

public class ManiMap implements Serializable {
    private Integer id;

    private Integer maniId;

    private String model;

    private Integer fid;

    private Integer bwf;

    private Byte status;

    private String meta;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getManiId() {
        return maniId;
    }

    public void setManiId(Integer maniId) {
        this.maniId = maniId;
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

    public Integer getBwf() {
        return bwf;
    }

    public void setBwf(Integer bwf) {
        this.bwf = bwf;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
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
        sb.append(", maniId=").append(maniId);
        sb.append(", model=").append(model);
        sb.append(", fid=").append(fid);
        sb.append(", bwf=").append(bwf);
        sb.append(", status=").append(status);
        sb.append(", meta=").append(meta);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}