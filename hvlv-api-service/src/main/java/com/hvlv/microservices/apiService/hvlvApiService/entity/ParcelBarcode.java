package com.hvlv.microservices.apiService.hvlvApiService.entity;

import java.io.Serializable;

public class ParcelBarcode implements Serializable {
    private Integer id;

    private String mainRef;

    private String fid;

    private String subRef;

    private String sn;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMainRef() {
        return mainRef;
    }

    public void setMainRef(String mainRef) {
        this.mainRef = mainRef;
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public String getSubRef() {
        return subRef;
    }

    public void setSubRef(String subRef) {
        this.subRef = subRef;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", mainRef=").append(mainRef);
        sb.append(", fid=").append(fid);
        sb.append(", subRef=").append(subRef);
        sb.append(", sn=").append(sn);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}