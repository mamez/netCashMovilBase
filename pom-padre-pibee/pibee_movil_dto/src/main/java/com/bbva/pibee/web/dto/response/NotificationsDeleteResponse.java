package com.bbva.pibee.web.dto.response;
import java.util.List;

import com.bbva.pibee.web.dto.notifi.entity.NotificationsDeleteModel;
import com.fasterxml.jackson.annotation.JsonProperty;

public class NotificationsDeleteResponse {
	private List<NotificationsDeleteModel> notifications;

	@JsonProperty("notifications")
	public List<NotificationsDeleteModel> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<NotificationsDeleteModel> notifications) {
		this.notifications = notifications;
	}
}
