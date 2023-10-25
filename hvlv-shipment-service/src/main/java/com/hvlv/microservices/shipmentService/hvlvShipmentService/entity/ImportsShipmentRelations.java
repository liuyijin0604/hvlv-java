package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;
import java.util.Date;

public class ImportsShipmentRelations implements Serializable {
    private Integer id;

    private Integer cid;

    private Integer pid;

    private Integer labelLo;

    private Integer labelHi;

    private Integer blueLabel;

    private Date created;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getLabelLo() {
        return labelLo;
    }

    public void setLabelLo(Integer labelLo) {
        this.labelLo = labelLo;
    }

    public Integer getLabelHi() {
        return labelHi;
    }

    public void setLabelHi(Integer labelHi) {
        this.labelHi = labelHi;
    }

    public Integer getBlueLabel() {
        return blueLabel;
    }

    public void setBlueLabel(Integer blueLabel) {
        this.blueLabel = blueLabel;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", cid=").append(cid);
        sb.append(", pid=").append(pid);
        sb.append(", labelLo=").append(labelLo);
        sb.append(", labelHi=").append(labelHi);
        sb.append(", blueLabel=").append(blueLabel);
        sb.append(", created=").append(created);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}