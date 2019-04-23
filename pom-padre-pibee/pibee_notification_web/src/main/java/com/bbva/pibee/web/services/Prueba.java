package com.bbva.pibee.web.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/V1/prueba")
public interface Prueba {
	
	@GET	
	@Produces("application/json")
	@Consumes("application/json")
	public Response getUsuario();

}
