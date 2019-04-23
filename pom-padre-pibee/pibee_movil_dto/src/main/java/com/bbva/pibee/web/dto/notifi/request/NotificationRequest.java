package com.bbva.pibee.web.dto.notifi.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NotificationRequest
{
	private List<NotificationEntityRequest> requestNotificationDele;
	
	
	@JsonProperty("notification")
	public List<NotificationEntityRequest> getRequestNotificationDele() {
		return requestNotificationDele;
	}

	public void setRequestNotificationDele(List<NotificationEntityRequest> requestNotificationDele) {
		this.requestNotificationDele = requestNotificationDele;
	}

	
	
}
