/*
* Classname:    WSAsyncResult.java
* Author:       Héctor Hernández Chávez
* Date:         25-jun-2019
*/
package javaee.examples.jaxrs.async.result.ws;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * @author Héctor Hernández Chávez
 */
@Path("async-result")
public class WSAsyncResult {

    @GET
    public Response getTime() {
        try {
            TimeUnit.SECONDS.sleep(5);
            long id = new Date().getTime();
            return Response.ok("time:" + id).build();
        } catch (InterruptedException ie) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ie).build();
        }
    }
}
