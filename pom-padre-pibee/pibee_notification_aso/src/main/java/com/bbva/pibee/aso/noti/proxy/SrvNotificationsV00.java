/**
 * Created by Apache CXF WadlToJava code generator
**/
package com.bbva.pibee.aso.noti.proxy;

import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.bbva.pibee.aso.noti.dto.Enrollment;

@Path("/V00")
public interface SrvNotificationsV00 {

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/enrollments")
    Response createEnrollment(@HeaderParam("user") String user, @HeaderParam("appid") String appid, @HeaderParam("appkey") String appkey, Enrollment enrollment);

    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/enrollments/{enrollment-id}")
    Response modifyEnrollment(@PathParam("enrollment-id") String enrollment_id, @HeaderParam("appid") String appid, @HeaderParam("appkey") String appkey, Enrollment enrollment);

}