package com.bbva.pibee.config.web;

import javax.ws.rs.container.ContainerRequestContext;

import com.bbva.pibee.arq.container.StatusBBVA;
import com.bbva.pibee.context.RequestInterceptor;
import com.bbva.pibee.rest.util.FilterInterceptorApplication;

public class FilterNotification implements FilterInterceptorApplication {

	@Override
	public void filter(ContainerRequestContext requestContext, RequestInterceptor interceptor) {
		try {
			String reference = requestContext.getHeaderString("iv-cod_emp");
			String userId = requestContext.getHeaderString("iv-cod_usu");
			String originNoti = requestContext.getHeaderString("iv-origen");
			String tsec = requestContext.getHeaderString("iv_ticketservice");
			if ((userId == null) || (userId.trim().equals("")) || (userId.equalsIgnoreCase("NOT_FOUND"))) {
				requestContext.abortWith(StatusBBVA.Unauthorized.Status("E002", "id user no valido"));
			} else if ((reference == null) || (reference.trim().equals("")) || (reference.equalsIgnoreCase("NOT_FOUND"))) {
				requestContext.abortWith(StatusBBVA.Unauthorized.Status("E004", "referencia no valida"));
			} else if ((originNoti == null) || (originNoti.trim().equals("")) || (originNoti.equalsIgnoreCase("NOT_FOUND"))) {
				requestContext.abortWith(StatusBBVA.Unauthorized.Status("E004", "origen no valido"));
			}else if ((tsec == null) || (tsec.trim().equals("")) || (tsec.equalsIgnoreCase("NOT_FOUND"))) {
				requestContext.abortWith(StatusBBVA.Unauthorized.Status("E004", "Tsec no valido"));
			}else {
				interceptor.setReference(reference);
				interceptor.setUserId(userId);
				interceptor.setIvorigin(originNoti);
				interceptor.setTsec(tsec);
			}
		} catch (Exception e) {
			requestContext.abortWith(StatusBBVA.Unauthorized.Status("002", "Error al filtrar cabeceras"));
		}

	}
}
