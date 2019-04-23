package com.bbva.pibee.rest.util;

import javax.ws.rs.container.ContainerRequestContext;

import com.bbva.pibee.context.RequestInterceptor;

public interface FilterInterceptorApplication {

	public void filter(ContainerRequestContext requestContext, RequestInterceptor interceptor);
	
}
