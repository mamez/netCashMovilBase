package com.bbva.pibee.aso.noti.core;

import java.io.Serializable;
import java.math.BigDecimal;
import java.net.ConnectException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;

import javax.annotation.Resource;

import org.apache.cxf.jaxrs.client.Client;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.apache.cxf.jaxrs.client.JAXRSClientFactoryBean;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.message.Message;
import org.springframework.beans.factory.annotation.Autowired;

import com.bbva.pibee.aop.LogNetCashMovil;
import com.bbva.pibee.context.RequestInterceptor;
import com.bbva.pibee.rest.exception.BbvaClientAsoException;
import com.bbva.pibee.rest.exception.CodClientException;
import  com.bbva.pibee.rest.exception.Error;
import com.bbva.pibee.rest.exception.ErrorInterno;

public abstract class HttpServiceBaseNoti implements Serializable {	
	
	private static final long serialVersionUID = 1905761822638277113L;
	
	@Autowired
	RequestInterceptor requestInterceptor;
	
	@Resource(name = "notificationFactoryBean")
	protected JAXRSClientFactoryBean notificationFactoryBean;

	public <P> P getService(String URL, Class<P> clase) {
		this.notificationFactoryBean.setAddress(URL);
		P client = JAXRSClientFactory.fromClient(this.notificationFactoryBean.createWebClient(), clase, true);
		WebClient.client(client).header("Content-Type", "application/json");
		return client;
	}
	
	public <P> P getNotificationFactoryBean(String URL, Class<P> clase) {
		this.notificationFactoryBean.setAddress(URL);
		P client = JAXRSClientFactory.fromClient(this.notificationFactoryBean.createWebClient(), clase, true);
		WebClient.client(client).header("Content-Type", "application/json");
		return client;
	}	
	
	protected <P> Error extractException(P proxy, Exception e) {
		ErrorInterno errorInterno= new ErrorInterno();
		LogNetCashMovil.logErrorPibee("Obteniendo error de ejecucion ASO: " + e.getMessage());
		Client client = WebClient.client(proxy);
		try {
			if (e.getCause() != null && e.getCause().getClass() == ConnectException.class) {
				errorInterno.setCodInterno("E007");
				errorInterno.setMsgInterno("Error al conectar capa aso");
				LogNetCashMovil.logErrorPibee("Error de conexion a ASO.................ConnectException");
			}
			int status = client.getResponse().getStatus();
			if (client.getResponse() != null) {
				if (client.getResponse().getStatus() != HttpResponseCodeNoti.NO_CONTENT) {
					String codHost, msgHost;
					LinkedHashMap<String, String> errorMap = client.getResponse().readEntity(LinkedHashMap.class);
					codHost = errorMap.get("error-code");
					msgHost = errorMap.get("error-message");
					errorInterno.setCodInterno(codHost);
					errorInterno.setMsgInterno(msgHost);
					LogNetCashMovil.logErrorPibee("Codigo hopst : "+codHost);
					LogNetCashMovil.logErrorPibee("Mensaje host : "+msgHost);
				} else {
					errorInterno.setCodInterno("E007");
					errorInterno.setMsgInterno("Error al conectar capa aso");
				}
			} else {
				errorInterno.setCodInterno("E007");
				errorInterno.setMsgInterno("Respuesta de host es nula");
				LogNetCashMovil.logErrorPibee("Respuesta de host es nula");
			}
		}catch (Exception internalExce) {
			if(internalExce instanceof BbvaClientAsoException) {
				errorInterno.setCodInterno("E007");
				errorInterno.setMsgInterno(internalExce.getMessage());
				LogNetCashMovil.logErrorPibee(internalExce.getMessage());
			}else {
				if(errorInterno.getCodInterno() == null) {
					errorInterno.setCodInterno("E007");
					errorInterno.setMsgInterno(internalExce.getMessage());
					LogNetCashMovil.logErrorPibee("Error Inicial: "+e.getMessage());
					LogNetCashMovil.logErrorPibee("Error interno: "+internalExce.getMessage());
				}
			
			}
		}
		return new Error(CodClientException.CLIENT_ERROR, "Error cliente", errorInterno);
	}
	
	protected <P> CodClientException extractExceptionPM(P proxy, Exception e) {
		LogNetCashMovil.logErrorPibee("Obteniendo error de ejecucion ASO: " + e.getMessage());
		Client client = WebClient.client(proxy);
		CodClientException resp=CodClientException.CLIENT_ERROR;
		try {
			int status = client.getResponse().getStatus();
			switch (status) {
			case 403:
				resp=CodClientException.INVALID_PARAMETERS;
				LogNetCashMovil.logErrorPibee("El cleinte detecto un error de parametros enviados: ");
				break;
			case 500:
				resp=CodClientException.CLIENT_ERROR;
				LogNetCashMovil.logErrorPibee("El servicio no encontro datos a listar ");
				break;
			case 204:
				resp=CodClientException.NO_DATA;
				LogNetCashMovil.logErrorPibee("El servicio no encontro datos a listar ");
				break;
			case 401:
				resp=CodClientException.INVALID_USER;
				LogNetCashMovil.logErrorPibee("Error al autenticar usuario ");
				break;
			case 404:
				resp=CodClientException.CLIENT_ERROR;
				LogNetCashMovil.logErrorPibee("Error al autenticar usuario ");
				break;
			}
		}catch (Exception internalExce) {
			resp=CodClientException.CLIENT_ERROR;
			LogNetCashMovil.logErrorPibee("Error en la letura del servicio"+ e.getMessage());
		}
		return resp;
	}

	protected String dateToAsoFormat(String fecha) throws BbvaClientAsoException {
		if (fecha != null) {
			SimpleDateFormat formatF = new SimpleDateFormat("yyyy-MM-dd");
			try {
				return formatF.format(formatF.parse(fecha));
			} catch (ParseException e) {
				throw new BbvaClientAsoException(CodClientException.INVALID_PARAMETERS);
			}
		} else {
			return fecha;
		}
	}

	protected String decimalToAsoFormat(String dato) throws BbvaClientAsoException {
		if (dato != null) {
			try {
				BigDecimal decimal = new BigDecimal(dato);
				return decimal.toString();
			} catch (NumberFormatException e) {
				throw new BbvaClientAsoException(CodClientException.INVALID_PARAMETERS);
			}
		} else {
			return dato;
		}
	}

	public static boolean isAServiceLocal(Message outMessage) {
		return outMessage.getContextualProperty("org.apache.cxf.message.Message.ENDPOINT_ADDRESS").toString()
				.contains("/ccol/")
				|| outMessage.getContextualProperty("org.apache.cxf.message.Message.ENDPOINT_ADDRESS").toString()
						.contains("/czic/");
	}
}