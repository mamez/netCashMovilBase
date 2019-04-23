package com.bbva.pibee.web.dto.notifi.response;

import java.util.List;

import com.bbva.pibee.web.dto.notifi.entity.NotificationModel;
import com.bbva.pibee.web.dto.response.entity.PaginationModel;
import com.fasterxml.jackson.annotation.JsonProperty;

public class NotificationServiceResponse extends PaginationModel
{
	private static final long serialVersionUID = 1L;
	public List<NotificationModel> listNotification;
	
	@JsonProperty("notifications")
	public List<NotificationModel> getListNotification() {
		return listNotification;
	}

	public void setListNotification(List<NotificationModel> listNotification) {
		this.listNotification = listNotification;
	}
}
