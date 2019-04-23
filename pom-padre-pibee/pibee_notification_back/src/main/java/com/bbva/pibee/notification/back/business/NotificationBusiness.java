package com.bbva.pibee.notification.back.business;

import com.bbva.pibee.rest.exception.BbvaClientBackException;
import com.bbva.pibee.web.dto.notifi.request.NotificationEntityRequest;
import com.bbva.pibee.web.dto.notifi.request.NotificationsDeleteRequest;
import com.bbva.pibee.web.dto.notifi.response.NotificationServiceResponse;
import com.bbva.pibee.web.dto.response.NotificationsDeleteResponse;

public interface NotificationBusiness 
{
	public NotificationServiceResponse getNotifications(int metodo) throws BbvaClientBackException;
	public NotificationServiceResponse deleteAllNotificationByUser() throws BbvaClientBackException;
	public NotificationsDeleteResponse deleteNotification(NotificationsDeleteRequest notificaciones) throws BbvaClientBackException;
	public void deleteAllNotification(NotificationsDeleteRequest notificaciones) throws BbvaClientBackException;
	public int updateNotifications(NotificationEntityRequest notiReq) throws BbvaClientBackException;
	void createNotification(NotificationEntityRequest notiReq) throws BbvaClientBackException;
}
