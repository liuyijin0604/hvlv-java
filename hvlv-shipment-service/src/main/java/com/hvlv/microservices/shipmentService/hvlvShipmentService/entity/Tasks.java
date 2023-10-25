package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;
import java.util.Date;

public class Tasks implements Serializable {
    private Integer id;

    /**
     * task type:
1 - pickup items from agent 
2 - reserved
     *
     * @mbg.generated
     */
    private Byte type;

    private Integer driverId;

    private Integer agentId;

    private String pickupTimeFrom;

    private String pickupTimeTo;

    /**
     * repeat type:

1 - Mon
2 - Tue
4 - Wed
8 - Thu
16 - Fri
32 - Sat
64 - Sun
128 - monthly
256 - by year
     *
     * @mbg.generated
     */
    private Short repeat;

    private String notes;

    private Date addedTime;

    /**
     * active or not
0 - inactive
1 - active
     *
     * @mbg.generated
     */
    private Byte active;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    public String getPickupTimeFrom() {
        return pickupTimeFrom;
    }

    public void setPickupTimeFrom(String pickupTimeFrom) {
        this.pickupTimeFrom = pickupTimeFrom;
    }

    public String getPickupTimeTo() {
        return pickupTimeTo;
    }

    public void setPickupTimeTo(String pickupTimeTo) {
        this.pickupTimeTo = pickupTimeTo;
    }

    public Short getRepeat() {
        return repeat;
    }

    public void setRepeat(Short repeat) {
        this.repeat = repeat;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Date getAddedTime() {
        return addedTime;
    }

    public void setAddedTime(Date addedTime) {
        this.addedTime = addedTime;
    }

    public Byte getActive() {
        return active;
    }

    public void setActive(Byte active) {
        this.active = active;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", type=").append(type);
        sb.append(", driverId=").append(driverId);
        sb.append(", agentId=").append(agentId);
        sb.append(", pickupTimeFrom=").append(pickupTimeFrom);
        sb.append(", pickupTimeTo=").append(pickupTimeTo);
        sb.append(", repeat=").append(repeat);
        sb.append(", notes=").append(notes);
        sb.append(", addedTime=").append(addedTime);
        sb.append(", active=").append(active);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}