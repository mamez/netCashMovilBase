package com.bbva.pibee.aso.noti.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NotificationPush 
{
	
	@NotNull
    private Notification notification;
    private String os;
    private String recipient;
    private String priority;
    private Integer timeToLive;
    private String collapseKey;
    private String applicationId;

  
    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification value) {
        this.notification = value;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String value) {
        this.os = value;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String value) {
        this.recipient = value;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String value) {
        this.priority = value;
    }

    public Integer getTimeToLive() {
        return timeToLive;
    }

    public void setTimeToLive(Integer value) {
        this.timeToLive = value;
    }

    public String getCollapseKey() {
        return collapseKey;
    }

    public void setCollapseKey(String value) {
        this.collapseKey = value;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String value) {
        this.applicationId = value;
    }

}
