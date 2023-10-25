package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;
import java.util.Date;

public class LiveChatDetail implements Serializable {
    private Integer id;

    private String agentEmail;

    private Date startedTimestamp;

    private Date endedTimestamp;

    private String visitorName;

    private String visitorEmail;

    private Integer visitorContactNumber;

    private String visitorCity;

    private String visitorCountry;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAgentEmail() {
        return agentEmail;
    }

    public void setAgentEmail(String agentEmail) {
        this.agentEmail = agentEmail;
    }

    public Date getStartedTimestamp() {
        return startedTimestamp;
    }

    public void setStartedTimestamp(Date startedTimestamp) {
        this.startedTimestamp = startedTimestamp;
    }

    public Date getEndedTimestamp() {
        return endedTimestamp;
    }

    public void setEndedTimestamp(Date endedTimestamp) {
        this.endedTimestamp = endedTimestamp;
    }

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    public String getVisitorEmail() {
        return visitorEmail;
    }

    public void setVisitorEmail(String visitorEmail) {
        this.visitorEmail = visitorEmail;
    }

    public Integer getVisitorContactNumber() {
        return visitorContactNumber;
    }

    public void setVisitorContactNumber(Integer visitorContactNumber) {
        this.visitorContactNumber = visitorContactNumber;
    }

    public String getVisitorCity() {
        return visitorCity;
    }

    public void setVisitorCity(String visitorCity) {
        this.visitorCity = visitorCity;
    }

    public String getVisitorCountry() {
        return visitorCountry;
    }

    public void setVisitorCountry(String visitorCountry) {
        this.visitorCountry = visitorCountry;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", agentEmail=").append(agentEmail);
        sb.append(", startedTimestamp=").append(startedTimestamp);
        sb.append(", endedTimestamp=").append(endedTimestamp);
        sb.append(", visitorName=").append(visitorName);
        sb.append(", visitorEmail=").append(visitorEmail);
        sb.append(", visitorContactNumber=").append(visitorContactNumber);
        sb.append(", visitorCity=").append(visitorCity);
        sb.append(", visitorCountry=").append(visitorCountry);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}