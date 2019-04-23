package com.bbva.pibee.rest.exception;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.bbva.pibee.arq.container.StatusBBVA;

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class Bbva404ExceptionMapper implements ExceptionMapper<NotFoundException> {

	@Override
	public Response toResponse(NotFoundException exception) {
		 return StatusBBVA.NotFound.Status();
	}

}
