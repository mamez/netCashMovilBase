package com.bbva.pibee.aso.noti.impl;

import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.Client;
import org.apache.cxf.jaxrs.client.WebClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.bbva.pibee.aop.LogNetCashMovil;
import com.bbva.pibee.arq.annotations.ClientAso;
import com.bbva.pibee.aso.noti.core.HttpServiceBaseNoti;
import com.bbva.pibee.aso.noti.dto.NotificationPush;
import com.bbva.pibee.aso.noti.inter.NotificationService;
import com.bbva.pibee.aso.noti.proxy.SrvNotificationsGatewayV00;
import com.bbva.pibee.rest.exception.BbvaClientAsoException;
import com.bbva.pibee.rest.exception.CodClientException;

@ClientAso
public class NotificationServiceImpl extends HttpServiceBaseNoti implements NotificationService 
{
	private static final long serialVersionUID = 1L;
	
	@Autowired
	Environment env;

	@Override
	public String sendNotification(NotificationPush notificationpush) throws BbvaClientAsoException {
		Response resp;
		String location=null;
		LogNetCashMovil.logDebugPibee("Ejecutando notificationPush");
		SrvNotificationsGatewayV00 proxy = this.getService(env.getProperty("pibee.aso.send.noti"), SrvNotificationsGatewayV00.class);		
		LogNetCashMovil.logDebugPibee("url"+env.getProperty("pibee.aso.send.noti"));
		try
		{
			proxy.createNotificationPush(notificationpush);
			Client client = WebClient.client(proxy);
			resp = client.getResponse();
			
			if(resp.getStatus() == 201){
				location=resp.getHeaderString("Location");
				}else {
					throw new BbvaClientAsoException(CodClientException.CLIENT_ERROR);
				}			
			LogNetCashMovil.logDebugPibee("Servicio notificationPush OK");
		}
		catch (Exception e){
			throw new BbvaClientAsoException(extractException(proxy, e));
		}		
		return location;
	}

	
	

}
