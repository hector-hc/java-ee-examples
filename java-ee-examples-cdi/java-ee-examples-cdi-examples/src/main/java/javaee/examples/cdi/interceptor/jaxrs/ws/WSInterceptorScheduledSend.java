/*
* Classname:    WSInterceptorScheduledSend.java
* Author:       Héctor Hernández Chávez
* Date:         22-jul-2019
*/
package javaee.examples.cdi.interceptor.jaxrs.ws;

import javaee.examples.cdi.interceptor.jaxrs.RequestScheduledSend;
import javaee.examples.cdi.interceptor.jaxrs.ScheduledSendInterceptor;
import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Héctor Hernández Chávez
 */
@Path("interceptor/scheduled-send")
public class WSInterceptorScheduledSend {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @ScheduledSendInterceptor
    public Response send(@HeaderParam("accountId") Integer accountId, 
            @HeaderParam("userId") Integer userId, RequestScheduledSend request) {
        System.out.println("accountId: " + accountId);
        System.out.println("userId: " + userId);
        System.out.println("RequestScheduledSend.scheduleSend: " + request.getScheduleSend());
        return Response.ok("OK").build();
    }
}
