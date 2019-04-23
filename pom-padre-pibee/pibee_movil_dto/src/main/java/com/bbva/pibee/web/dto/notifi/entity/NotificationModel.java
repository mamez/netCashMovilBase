package com.bbva.pibee.web.dto.notifi.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NotificationModel
{

	private String id;
	private String date;
	private String state;	
	private String title;
	private String description;	
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
	@JsonProperty("date")
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
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

}
