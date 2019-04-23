package com.bbva.pibee.web.services;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.bbva.pibee.rest.exception.BbvaClientBackException;
import com.bbva.pibee.web.dto.notifi.request.ConfigurationEntityRequest;

@Path("/V1/configuration")
public interface ConfigurationService
{
	@GET
	@Produces("application/json")
	@Consumes("application/json")
	public Response getConfigurations() throws BbvaClientBackException;
	
	@PUT	
	@Produces("application/json")
	@Consumes("application/json")
	public Response insertConfiguration(@Valid ConfigurationEntityRequest configReq) throws BbvaClientBackException;	
}
