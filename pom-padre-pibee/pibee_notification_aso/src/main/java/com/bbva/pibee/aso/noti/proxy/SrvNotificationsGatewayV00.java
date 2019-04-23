/**
 * Created by Apache CXF WadlToJava code generator
**/
package com.bbva.pibee.aso.noti.proxy;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.bbva.pibee.aso.noti.dto.NotificationPush;

public interface SrvNotificationsGatewayV00 {

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    Response createNotificationPush(NotificationPush notificationpush);

}