package com.bbva.pibee.rest.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import org.springframework.stereotype.Component;

@Component
public class BbvaFilterException implements ExceptionMapper<Throwable>{

	@Override
	public Response toResponse(Throwable exception) {
		return Response.status(Response.Status.UNAUTHORIZED).entity("sss").build();
	}

}
