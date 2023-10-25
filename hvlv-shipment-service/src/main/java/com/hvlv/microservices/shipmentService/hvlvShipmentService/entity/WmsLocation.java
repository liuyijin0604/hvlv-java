package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class WmsLocation implements Serializable {
    private Integer id;

    private Integer wid;

    private Integer pid;

    private Byte type;

    private Byte status;

    private String name;

    private String code;

    private Integer cx;

    private Integer cy;

    private Integer cz;

    private Integer cap;

    private BigDecimal capKg;

    private BigDecimal capCbm;

    private Integer capItem;

    private BigDecimal width;

    private BigDecimal height;

    private BigDecimal depth;

    private Integer bwf;

    private Integer wt;

    private String groundLabel;

    private Date groundLabelInTime;

    private String prefix;

    private String notes;

    private String meta;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getCx() {
        return cx;
    }

    public void setCx(Integer cx) {
        this.cx = cx;
    }

    public Integer getCy() {
        return cy;
    }

    public void setCy(Integer cy) {
        this.cy = cy;
    }

    public Integer getCz() {
        return cz;
    }

    public void setCz(Integer cz) {
        this.cz = cz;
    }

    public Integer getCap() {
        return cap;
    }

    public void setCap(Integer cap) {
        this.cap = cap;
    }

    public BigDecimal getCapKg() {
        return capKg;
    }

    public void setCapKg(BigDecimal capKg) {
        this.capKg = capKg;
    }

    public BigDecimal getCapCbm() {
        return capCbm;
    }

    public void setCapCbm(BigDecimal capCbm) {
        this.capCbm = capCbm;
    }

    public Integer getCapItem() {
        return capItem;
    }

    public void setCapItem(Integer capItem) {
        this.capItem = capItem;
    }

    public BigDecimal getWidth() {
        return width;
    }

    public void setWidth(BigDecimal width) {
        this.width = width;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public BigDecimal getDepth() {
        return depth;
    }

    public void setDepth(BigDecimal depth) {
        this.depth = depth;
    }

    public Integer getBwf() {
        return bwf;
    }

    public void setBwf(Integer bwf) {
        this.bwf = bwf;
    }

    public Integer getWt() {
        return wt;
    }

    public void setWt(Integer wt) {
        this.wt = wt;
    }

    public String getGroundLabel() {
        return groundLabel;
    }

    public void setGroundLabel(String groundLabel) {
        this.groundLabel = groundLabel;
    }

    public Date getGroundLabelInTime() {
        return groundLabelInTime;
    }

    public void setGroundLabelInTime(Date groundLabelInTime) {
        this.groundLabelInTime = groundLabelInTime;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
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
        sb.append(", wid=").append(wid);
        sb.append(", pid=").append(pid);
        sb.append(", type=").append(type);
        sb.append(", status=").append(status);
        sb.append(", name=").append(name);
        sb.append(", code=").append(code);
        sb.append(", cx=").append(cx);
        sb.append(", cy=").append(cy);
        sb.append(", cz=").append(cz);
        sb.append(", cap=").append(cap);
        sb.append(", capKg=").append(capKg);
        sb.append(", capCbm=").append(capCbm);
        sb.append(", capItem=").append(capItem);
        sb.append(", width=").append(width);
        sb.append(", height=").append(height);
        sb.append(", depth=").append(depth);
        sb.append(", bwf=").append(bwf);
        sb.append(", wt=").append(wt);
        sb.append(", groundLabel=").append(groundLabel);
        sb.append(", groundLabelInTime=").append(groundLabelInTime);
        sb.append(", prefix=").append(prefix);
        sb.append(", notes=").append(notes);
        sb.append(", meta=").append(meta);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}