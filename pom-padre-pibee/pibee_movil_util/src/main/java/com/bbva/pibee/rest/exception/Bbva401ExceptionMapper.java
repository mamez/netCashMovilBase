package com.bbva.pibee.rest.exception;

import javax.ws.rs.ForbiddenException;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.bbva.pibee.arq.container.StatusBBVA;

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class Bbva401ExceptionMapper implements ExceptionMapper<ForbiddenException> {

	@Override
	public Response toResponse(ForbiddenException exception) {
		 return StatusBBVA.Unauthorized.Status();
	}

}
