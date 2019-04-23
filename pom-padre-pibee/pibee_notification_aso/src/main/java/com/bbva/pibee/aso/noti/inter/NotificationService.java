package com.bbva.pibee.aso.noti.inter;

import com.bbva.pibee.aso.noti.dto.NotificationPush;
import com.bbva.pibee.rest.exception.BbvaClientAsoException;

public interface NotificationService 
{
	public String sendNotification(NotificationPush notificationpush) throws BbvaClientAsoException;
}
