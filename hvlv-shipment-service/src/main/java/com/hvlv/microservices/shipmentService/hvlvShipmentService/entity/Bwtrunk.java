package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;
import java.util.Date;

public class Bwtrunk implements Serializable {
    private Integer id;

    private String mawbNumber;

    private Integer piecesPickUp;

    private Date ctoStart;

    private Date ctoFinish;

    private Date clientStart;

    private Date clientFinish;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMawbNumber() {
        return mawbNumber;
    }

    public void setMawbNumber(String mawbNumber) {
        this.mawbNumber = mawbNumber;
    }

    public Integer getPiecesPickUp() {
        return piecesPickUp;
    }

    public void setPiecesPickUp(Integer piecesPickUp) {
        this.piecesPickUp = piecesPickUp;
    }

    public Date getCtoStart() {
        return ctoStart;
    }

    public void setCtoStart(Date ctoStart) {
        this.ctoStart = ctoStart;
    }

    public Date getCtoFinish() {
        return ctoFinish;
    }

    public void setCtoFinish(Date ctoFinish) {
        this.ctoFinish = ctoFinish;
    }

    public Date getClientStart() {
        return clientStart;
    }

    public void setClientStart(Date clientStart) {
        this.clientStart = clientStart;
    }

    public Date getClientFinish() {
        return clientFinish;
    }

    public void setClientFinish(Date clientFinish) {
        this.clientFinish = clientFinish;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", mawbNumber=").append(mawbNumber);
        sb.append(", piecesPickUp=").append(piecesPickUp);
        sb.append(", ctoStart=").append(ctoStart);
        sb.append(", ctoFinish=").append(ctoFinish);
        sb.append(", clientStart=").append(clientStart);
        sb.append(", clientFinish=").append(clientFinish);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}