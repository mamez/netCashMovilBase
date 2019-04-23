package com.bbva.pibee.web.dto.notifi.request;

import java.io.Serializable;

import javax.management.Notification;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NotificationEntityRequest implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String state;
	private String date;
	
	@NotNull
	private String title;
	@NotNull
	private String description;	
	@NotNull
	private int fkConfig;
	private String codeTransaction;
	private String originNoti;
	
	
	
	@JsonProperty("id")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@JsonProperty("state")
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@JsonProperty("title")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@JsonProperty("description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@JsonProperty("fkConfig")
	public int getFkConfig() {
		return fkConfig;
	}
	public void setFkConfig(int fkConfig) {
		this.fkConfig = fkConfig;
	}
	@JsonProperty("codeTransaction")
	public String getCodeTransaction() {
		return codeTransaction;
	}
	public void setCodeTransaction(String codeTransaction) {
		this.codeTransaction = codeTransaction;
	}
	@JsonProperty("originNotification")
	public String getOriginNoti() {
		return originNoti;
	}
	public void setOriginNoti(String originNoti) {
		this.originNoti = originNoti;
	}

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
