package com.bbva.pibee.aso.noti.impl;

import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.Client;
import org.apache.cxf.jaxrs.client.WebClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.bbva.pibee.aop.LogNetCashMovil;
import com.bbva.pibee.arq.annotations.ClientAso;
import com.bbva.pibee.aso.noti.core.HttpServiceBaseNoti;
import com.bbva.pibee.aso.noti.dto.Enrollment;
import com.bbva.pibee.aso.noti.inter.EnrollmentService;
import com.bbva.pibee.aso.noti.proxy.SrvNotificationsV00;
import com.bbva.pibee.rest.exception.BbvaClientAsoException;
import com.bbva.pibee.rest.exception.CodClientException;

@ClientAso
public class EnrollmentServiceImpl extends HttpServiceBaseNoti implements EnrollmentService
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired	
	private Environment env;

	
	public String createEnrollment(String idUser, String appId, String appKey, Enrollment user)
			throws BbvaClientAsoException {
		Response resp;
		String location=null;
		LogNetCashMovil.logDebugPibee("Ejecutando createEnrollment");
		SrvNotificationsV00 proxy = this.getService(env.getProperty("pibee.aso.create.user"), SrvNotificationsV00.class);
		try{
			proxy.createEnrollment(idUser, appId, appKey, user);
			Client client = WebClient.client(proxy);
			resp = client.getResponse();
			if(resp.getStatus() == 201){
			LogNetCashMovil.logDebugPibee("Tromando valor location ");
			location=resp.getHeaderString("Location");
			LogNetCashMovil.logDebugPibee("Valor location= "+location);
			}else {
				 
				throw new BbvaClientAsoException(CodClientException.CLIENT_ERROR);
			}			
			LogNetCashMovil.logDebugPibee("Servicio createEnrollment OK");
		}
		catch (Exception e)
		{
			throw new BbvaClientAsoException(extractException(proxy, e));
		}
		return location;
	}

	public void modifyEnrollment(String enrollmentId, String appId, String appKey, Enrollment user) throws BbvaClientAsoException {
		Response resp;
		LogNetCashMovil.logDebugPibee("Ejecutando modifyEnrollment");
		SrvNotificationsV00 proxy = this.getService(env.getProperty("pibee.aso.create.user"), SrvNotificationsV00.class);
		try{
			proxy.modifyEnrollment(enrollmentId, appId, appKey,  user);
			Client client = WebClient.client(proxy);
			resp = client.getResponse();
			
			if(resp.getStatus() != 204){
				throw new BbvaClientAsoException(CodClientException.CLIENT_ERROR);
			}
			
			LogNetCashMovil.logDebugPibee("Servicio createEnrollment OK");
		}
		catch (Exception e){
			throw new BbvaClientAsoException(extractException(proxy, e));
		}
	}
	
}
