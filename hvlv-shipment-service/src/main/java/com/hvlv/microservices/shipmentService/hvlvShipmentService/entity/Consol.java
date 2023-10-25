package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;
import java.util.Date;

public class Consol implements Serializable {
    private Integer id;

    private Integer pcId;

    private String no;

    private Integer ownerId;

    private Integer dptId;

    private Integer carrierId;

    private Byte type;

    private Byte service;

    private String awb;

    private String airline;

    private String flight;

    private Float exrate;

    private String pol;

    private String pod;

    private String poc;

    private Date etd;

    private Date eta;

    private Date created;

    private Byte status;

    private Integer bwf;

    private String containerNo;

    private String meta;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPcId() {
        return pcId;
    }

    public void setPcId(Integer pcId) {
        this.pcId = pcId;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getDptId() {
        return dptId;
    }

    public void setDptId(Integer dptId) {
        this.dptId = dptId;
    }

    public Integer getCarrierId() {
        return carrierId;
    }

    public void setCarrierId(Integer carrierId) {
        this.carrierId = carrierId;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Byte getService() {
        return service;
    }

    public void setService(Byte service) {
        this.service = service;
    }

    public String getAwb() {
        return awb;
    }

    public void setAwb(String awb) {
        this.awb = awb;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getFlight() {
        return flight;
    }

    public void setFlight(String flight) {
        this.flight = flight;
    }

    public Float getExrate() {
        return exrate;
    }

    public void setExrate(Float exrate) {
        this.exrate = exrate;
    }

    public String getPol() {
        return pol;
    }

    public void setPol(String pol) {
        this.pol = pol;
    }

    public String getPod() {
        return pod;
    }

    public void setPod(String pod) {
        this.pod = pod;
    }

    public String getPoc() {
        return poc;
    }

    public void setPoc(String poc) {
        this.poc = poc;
    }

    public Date getEtd() {
        return etd;
    }

    public void setEtd(Date etd) {
        this.etd = etd;
    }

    public Date getEta() {
        return eta;
    }

    public void setEta(Date eta) {
        this.eta = eta;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Integer getBwf() {
        return bwf;
    }

    public void setBwf(Integer bwf) {
        this.bwf = bwf;
    }

    public String getContainerNo() {
        return containerNo;
    }

    public void setContainerNo(String containerNo) {
        this.containerNo = containerNo;
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
        sb.append(", pcId=").append(pcId);
        sb.append(", no=").append(no);
        sb.append(", ownerId=").append(ownerId);
        sb.append(", dptId=").append(dptId);
        sb.append(", carrierId=").append(carrierId);
        sb.append(", type=").append(type);
        sb.append(", service=").append(service);
        sb.append(", awb=").append(awb);
        sb.append(", airline=").append(airline);
        sb.append(", flight=").append(flight);
        sb.append(", exrate=").append(exrate);
        sb.append(", pol=").append(pol);
        sb.append(", pod=").append(pod);
        sb.append(", poc=").append(poc);
        sb.append(", etd=").append(etd);
        sb.append(", eta=").append(eta);
        sb.append(", created=").append(created);
        sb.append(", status=").append(status);
        sb.append(", bwf=").append(bwf);
        sb.append(", containerNo=").append(containerNo);
        sb.append(", meta=").append(meta);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}