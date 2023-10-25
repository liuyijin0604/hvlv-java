package com.hvlv.microservices.apiService.hvlvApiService.entity;

import java.io.Serializable;
import java.util.Date;

public class Manifest implements Serializable {
    private Integer id;

    private Integer fwdId;

    private Integer consolId;

    private Integer dptId;

    private Integer byId;

    private Integer type;

    private Byte status;

    private Date created;

    private Float total;

    private Integer bwf;

    private Integer company;

    private String ref;

    private String meta;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFwdId() {
        return fwdId;
    }

    public void setFwdId(Integer fwdId) {
        this.fwdId = fwdId;
    }

    public Integer getConsolId() {
        return consolId;
    }

    public void setConsolId(Integer consolId) {
        this.consolId = consolId;
    }

    public Integer getDptId() {
        return dptId;
    }

    public void setDptId(Integer dptId) {
        this.dptId = dptId;
    }

    public Integer getById() {
        return byId;
    }

    public void setById(Integer byId) {
        this.byId = byId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Integer getBwf() {
        return bwf;
    }

    public void setBwf(Integer bwf) {
        this.bwf = bwf;
    }

    public Integer getCompany() {
        return company;
    }

    public void setCompany(Integer company) {
        this.company = company;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
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
        sb.append(", fwdId=").append(fwdId);
        sb.append(", consolId=").append(consolId);
        sb.append(", dptId=").append(dptId);
        sb.append(", byId=").append(byId);
        sb.append(", type=").append(type);
        sb.append(", status=").append(status);
        sb.append(", created=").append(created);
        sb.append(", total=").append(total);
        sb.append(", bwf=").append(bwf);
        sb.append(", company=").append(company);
        sb.append(", ref=").append(ref);
        sb.append(", meta=").append(meta);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}