package com.bbva.pibee.web.dto.notifi.entity;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NotificationsDeleteModel {
	@NotNull
	private String id;
	
	private NotificationsStatus status;

	@JsonProperty("id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}	
	@JsonProperty("status")
	public NotificationsStatus getStatus() {
		return status;
	}

	public void setStatus(NotificationsStatus status) {
		this.status = status;
	}
    
	
}
