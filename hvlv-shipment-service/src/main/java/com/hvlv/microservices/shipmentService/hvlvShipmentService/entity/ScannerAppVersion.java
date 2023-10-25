package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;

public class ScannerAppVersion implements Serializable {
    private Integer id;

    /**
     * latest version id start from 1
     *
     * @mbg.generated
     */
    private Integer verid;

    /**
     * supports minimize version id start from 1
     *
     * @mbg.generated
     */
    private Integer min;

    /**
     * supports maximize version id start from 1
     *
     * @mbg.generated
     */
    private Integer max;

    /**
     * latest version string 
i.e. V1.2.1
     *
     * @mbg.generated
     */
    private String verstr;

    private String updateurl;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVerid() {
        return verid;
    }

    public void setVerid(Integer verid) {
        this.verid = verid;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public String getVerstr() {
        return verstr;
    }

    public void setVerstr(String verstr) {
        this.verstr = verstr;
    }

    public String getUpdateurl() {
        return updateurl;
    }

    public void setUpdateurl(String updateurl) {
        this.updateurl = updateurl;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", verid=").append(verid);
        sb.append(", min=").append(min);
        sb.append(", max=").append(max);
        sb.append(", verstr=").append(verstr);
        sb.append(", updateurl=").append(updateurl);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}