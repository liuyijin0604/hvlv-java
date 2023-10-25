package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;
import java.util.Date;

public class ExImage implements Serializable {
    private Integer id;

    private String fileAdr;

    private String hbn;

    private byte[] islinked;

    private String agentId;

    private String pdfNumber;

    private Date date;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileAdr() {
        return fileAdr;
    }

    public void setFileAdr(String fileAdr) {
        this.fileAdr = fileAdr;
    }

    public String getHbn() {
        return hbn;
    }

    public void setHbn(String hbn) {
        this.hbn = hbn;
    }

    public byte[] getIslinked() {
        return islinked;
    }

    public void setIslinked(byte[] islinked) {
        this.islinked = islinked;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getPdfNumber() {
        return pdfNumber;
    }

    public void setPdfNumber(String pdfNumber) {
        this.pdfNumber = pdfNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", fileAdr=").append(fileAdr);
        sb.append(", hbn=").append(hbn);
        sb.append(", islinked=").append(islinked);
        sb.append(", agentId=").append(agentId);
        sb.append(", pdfNumber=").append(pdfNumber);
        sb.append(", date=").append(date);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}