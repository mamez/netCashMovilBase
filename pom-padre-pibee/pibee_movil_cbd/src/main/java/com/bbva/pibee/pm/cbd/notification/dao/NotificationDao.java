package com.bbva.pibee.pm.cbd.notification.dao;

import java.util.List;

import com.bbva.pibee.dto.notification.NotificationDto;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;

public interface NotificationDao 
{
	public List<NotificationDto> getNotification(String usuRefe, String usuId) throws BbvaClientCbdException;
	public List<NotificationDto> getOneNotification(String usuRefe, String usuId, int idNoti) throws BbvaClientCbdException;
	public void deleteAllNotificationByUser(String userRef, String userId) throws BbvaClientCbdException;
	public int deleteNotification(String idNoti) throws BbvaClientCbdException;
	public int updateNotification(String idNoti) throws BbvaClientCbdException;
	void insertNotification(NotificationDto noti) throws BbvaClientCbdException;
	
	}
