/*
* Classname:    WSAsync.java
* Author:       Héctor Hernández Chávez
* Date:         25-jun-2019
*/
package javaee.examples.jaxrs.async.result.ws;

import javaee.examples.jaxrs.async.result.client.AsyncResulClient;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Response;

/**
 * @author Héctor Hernández Chávez
 */
@Path("async-service")
public class WSAsync {

    @Inject
    AsyncResulClient asyncClient;
    
    @GET
    public void asyncService(@Suspended AsyncResponse response) {
        try {
            asyncClient.getResult().thenApply(this::readResponse).thenAccept(response::resume);
        } catch (Exception e) {
            response.resume(Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build());
        }
    }
    
    private String readResponse(Response response) {
        return response.readEntity(String.class);
    }
}
