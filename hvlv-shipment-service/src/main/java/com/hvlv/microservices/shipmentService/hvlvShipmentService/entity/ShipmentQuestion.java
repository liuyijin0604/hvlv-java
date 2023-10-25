package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;
import java.util.Date;

public class ShipmentQuestion implements Serializable {
    private Integer id;

    private Integer shipmentId;

    private Integer submitId;

    private Byte cRead;

    private Byte sRead;

    private String faq;

    private String faqAnswer;

    private Date answerDate;

    private Date crDate;

    private Integer processType;

    private Integer finishUserId;

    private String cNote;

    private String sNote;

    private String meta;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(Integer shipmentId) {
        this.shipmentId = shipmentId;
    }

    public Integer getSubmitId() {
        return submitId;
    }

    public void setSubmitId(Integer submitId) {
        this.submitId = submitId;
    }

    public Byte getcRead() {
        return cRead;
    }

    public void setcRead(Byte cRead) {
        this.cRead = cRead;
    }

    public Byte getsRead() {
        return sRead;
    }

    public void setsRead(Byte sRead) {
        this.sRead = sRead;
    }

    public String getFaq() {
        return faq;
    }

    public void setFaq(String faq) {
        this.faq = faq;
    }

    public String getFaqAnswer() {
        return faqAnswer;
    }

    public void setFaqAnswer(String faqAnswer) {
        this.faqAnswer = faqAnswer;
    }

    public Date getAnswerDate() {
        return answerDate;
    }

    public void setAnswerDate(Date answerDate) {
        this.answerDate = answerDate;
    }

    public Date getCrDate() {
        return crDate;
    }

    public void setCrDate(Date crDate) {
        this.crDate = crDate;
    }

    public Integer getProcessType() {
        return processType;
    }

    public void setProcessType(Integer processType) {
        this.processType = processType;
    }

    public Integer getFinishUserId() {
        return finishUserId;
    }

    public void setFinishUserId(Integer finishUserId) {
        this.finishUserId = finishUserId;
    }

    public String getcNote() {
        return cNote;
    }

    public void setcNote(String cNote) {
        this.cNote = cNote;
    }

    public String getsNote() {
        return sNote;
    }

    public void setsNote(String sNote) {
        this.sNote = sNote;
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
        sb.append(", shipmentId=").append(shipmentId);
        sb.append(", submitId=").append(submitId);
        sb.append(", cRead=").append(cRead);
        sb.append(", sRead=").append(sRead);
        sb.append(", faq=").append(faq);
        sb.append(", faqAnswer=").append(faqAnswer);
        sb.append(", answerDate=").append(answerDate);
        sb.append(", crDate=").append(crDate);
        sb.append(", processType=").append(processType);
        sb.append(", finishUserId=").append(finishUserId);
        sb.append(", cNote=").append(cNote);
        sb.append(", sNote=").append(sNote);
        sb.append(", meta=").append(meta);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}