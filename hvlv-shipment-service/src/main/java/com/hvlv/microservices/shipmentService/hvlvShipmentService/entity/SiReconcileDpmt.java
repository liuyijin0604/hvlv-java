package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class SiReconcileDpmt implements Serializable {
    private Integer id;

    private Integer siReconcileId;

    private Integer dpmt;

    private Byte flag;

    private BigDecimal total;

    private String totalConfirmed;

    private BigDecimal totalGst;

    private String totalGstConfirmed;

    private String totalExGstConfirmed;

    private BigDecimal totalExGst;

    private Integer confirmStatus;

    private BigDecimal totalExGstApi;

    private BigDecimal totalExGstMy;

    private Integer status;

    private String meta;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSiReconcileId() {
        return siReconcileId;
    }

    public void setSiReconcileId(Integer siReconcileId) {
        this.siReconcileId = siReconcileId;
    }

    public Integer getDpmt() {
        return dpmt;
    }

    public void setDpmt(Integer dpmt) {
        this.dpmt = dpmt;
    }

    public Byte getFlag() {
        return flag;
    }

    public void setFlag(Byte flag) {
        this.flag = flag;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getTotalConfirmed() {
        return totalConfirmed;
    }

    public void setTotalConfirmed(String totalConfirmed) {
        this.totalConfirmed = totalConfirmed;
    }

    public BigDecimal getTotalGst() {
        return totalGst;
    }

    public void setTotalGst(BigDecimal totalGst) {
        this.totalGst = totalGst;
    }

    public String getTotalGstConfirmed() {
        return totalGstConfirmed;
    }

    public void setTotalGstConfirmed(String totalGstConfirmed) {
        this.totalGstConfirmed = totalGstConfirmed;
    }

    public String getTotalExGstConfirmed() {
        return totalExGstConfirmed;
    }

    public void setTotalExGstConfirmed(String totalExGstConfirmed) {
        this.totalExGstConfirmed = totalExGstConfirmed;
    }

    public BigDecimal getTotalExGst() {
        return totalExGst;
    }

    public void setTotalExGst(BigDecimal totalExGst) {
        this.totalExGst = totalExGst;
    }

    public Integer getConfirmStatus() {
        return confirmStatus;
    }

    public void setConfirmStatus(Integer confirmStatus) {
        this.confirmStatus = confirmStatus;
    }

    public BigDecimal getTotalExGstApi() {
        return totalExGstApi;
    }

    public void setTotalExGstApi(BigDecimal totalExGstApi) {
        this.totalExGstApi = totalExGstApi;
    }

    public BigDecimal getTotalExGstMy() {
        return totalExGstMy;
    }

    public void setTotalExGstMy(BigDecimal totalExGstMy) {
        this.totalExGstMy = totalExGstMy;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
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
        sb.append(", siReconcileId=").append(siReconcileId);
        sb.append(", dpmt=").append(dpmt);
        sb.append(", flag=").append(flag);
        sb.append(", total=").append(total);
        sb.append(", totalConfirmed=").append(totalConfirmed);
        sb.append(", totalGst=").append(totalGst);
        sb.append(", totalGstConfirmed=").append(totalGstConfirmed);
        sb.append(", totalExGstConfirmed=").append(totalExGstConfirmed);
        sb.append(", totalExGst=").append(totalExGst);
        sb.append(", confirmStatus=").append(confirmStatus);
        sb.append(", totalExGstApi=").append(totalExGstApi);
        sb.append(", totalExGstMy=").append(totalExGstMy);
        sb.append(", status=").append(status);
        sb.append(", meta=").append(meta);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}