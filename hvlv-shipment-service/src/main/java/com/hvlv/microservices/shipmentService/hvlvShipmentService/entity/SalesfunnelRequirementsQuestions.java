package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;

public class SalesfunnelRequirementsQuestions implements Serializable {
    private Integer id;

    private Integer questionNum;

    private String question;

    private Integer questionType;

    private Integer questionCategory;

    private Integer inactive;

    private Integer realNum;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuestionNum() {
        return questionNum;
    }

    public void setQuestionNum(Integer questionNum) {
        this.questionNum = questionNum;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Integer getQuestionType() {
        return questionType;
    }

    public void setQuestionType(Integer questionType) {
        this.questionType = questionType;
    }

    public Integer getQuestionCategory() {
        return questionCategory;
    }

    public void setQuestionCategory(Integer questionCategory) {
        this.questionCategory = questionCategory;
    }

    public Integer getInactive() {
        return inactive;
    }

    public void setInactive(Integer inactive) {
        this.inactive = inactive;
    }

    public Integer getRealNum() {
        return realNum;
    }

    public void setRealNum(Integer realNum) {
        this.realNum = realNum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", questionNum=").append(questionNum);
        sb.append(", question=").append(question);
        sb.append(", questionType=").append(questionType);
        sb.append(", questionCategory=").append(questionCategory);
        sb.append(", inactive=").append(inactive);
        sb.append(", realNum=").append(realNum);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}