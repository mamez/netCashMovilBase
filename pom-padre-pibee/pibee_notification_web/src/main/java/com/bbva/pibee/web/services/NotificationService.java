package com.bbva.pibee.web.services;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.bbva.pibee.rest.exception.BbvaClientBackException;
import com.bbva.pibee.rest.exception.BbvaFilterListException;
import com.bbva.pibee.web.dto.notifi.request.NotificationEntityRequest;
import com.bbva.pibee.web.dto.notifi.request.NotificationsDeleteRequest;
import com.bbva.pibee.web.dto.notifi.request.Usuario;

@Path("/V1/notification")
public interface NotificationService
{
	@GET	
	@Produces("application/json")
	@Consumes("application/json")
	public Response getNotification(@NotNull @Pattern(regexp = "\\d+") @QueryParam("paginationKey") String paginationKey,
			                    @NotNull @Pattern(regexp = "\\d+") @QueryParam("pageSize") String pageSize) throws BbvaClientBackException , BbvaFilterListException;
	@PUT
	@Path("/{id}")
	@Produces("application/json")
	@Consumes("application/json")
	public Response changeStateNotifications(@NotNull @PathParam("id") String id) throws BbvaClientBackException;
	
	@DELETE
	@Produces("application/json")
	@Consumes("application/json")
	public Response deleteNotifications(NotificationsDeleteRequest notificaciones) throws BbvaClientBackException;
	
	@DELETE
	@Path("/all")
	@Produces("application/json")
	@Consumes("application/json")
	public Response deleteNotifications() throws BbvaClientBackException;
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public Response saveNotifications( NotificationEntityRequest notiReq) throws BbvaClientBackException;	
}
