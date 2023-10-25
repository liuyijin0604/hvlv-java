package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class Route implements Serializable {
    private Integer id;

    private Integer airlineId;

    private String flightNo;

    private Byte status;

    private String destination;

    private String departure;

    private String code;

    private String stops;

    private String days;

    private BigDecimal ccaCharge;

    private BigDecimal awbP;

    private BigDecimal securityFuel;

    private String info;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(Integer airlineId) {
        this.airlineId = airlineId;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStops() {
        return stops;
    }

    public void setStops(String stops) {
        this.stops = stops;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public BigDecimal getCcaCharge() {
        return ccaCharge;
    }

    public void setCcaCharge(BigDecimal ccaCharge) {
        this.ccaCharge = ccaCharge;
    }

    public BigDecimal getAwbP() {
        return awbP;
    }

    public void setAwbP(BigDecimal awbP) {
        this.awbP = awbP;
    }

    public BigDecimal getSecurityFuel() {
        return securityFuel;
    }

    public void setSecurityFuel(BigDecimal securityFuel) {
        this.securityFuel = securityFuel;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", airlineId=").append(airlineId);
        sb.append(", flightNo=").append(flightNo);
        sb.append(", status=").append(status);
        sb.append(", destination=").append(destination);
        sb.append(", departure=").append(departure);
        sb.append(", code=").append(code);
        sb.append(", stops=").append(stops);
        sb.append(", days=").append(days);
        sb.append(", ccaCharge=").append(ccaCharge);
        sb.append(", awbP=").append(awbP);
        sb.append(", securityFuel=").append(securityFuel);
        sb.append(", info=").append(info);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}