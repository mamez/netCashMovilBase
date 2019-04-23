package com.bbva.pibee.aso.noti.core;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.cxf.interceptor.AbstractInDatabindingInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.Phase;
import org.springframework.beans.factory.annotation.Autowired;
import com.bbva.pibee.aop.LogNetCashMovil;
import com.bbva.pibee.context.RequestInterceptor;

public class RequestInterceptorNoti extends AbstractInDatabindingInterceptor{

	public RequestInterceptorNoti() {
		super(Phase.SEND_ENDING);
	}
	
	@Autowired
	RequestInterceptor requestInterceptor;
	
	
	public void handleMessage(Message outMessage) throws Fault {
		try {
		LogNetCashMovil.logDebugPibee("Añadiendo Usuarios a la peticion");
		@SuppressWarnings("unchecked")
		final Map<String, List<String>> headers = (Map<String, List<String>>) outMessage.get(Message.PROTOCOL_HEADERS);
		final String tsec = requestInterceptor.getTsec();
		headers.put("tsec",Arrays.asList(tsec));
		outMessage.put(Message.PROTOCOL_HEADERS, headers);
		} catch (Exception  exception) {
			LogNetCashMovil.logDebugPibee("ERROR REQUEST INTERCEPTOR: " + exception.getMessage());
			throw new Fault(exception);
		}
	}

}
