/**
 * @Class WSUserAsyncEjb
 * @author Hector
 * @Created on Jun 30, 2019, 1:18:08 PM
 */
package javaee.examples.jaxrs.async.ejb.ws;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import javaee.examples.jaxrs.async.ejb.GetterUserEJB;
import javaee.examples.jaxrs.async.ejb.UserAsyncEjb;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Response;

@Path("async-ejb")
public class WSUserAsyncEjb {

    @EJB
    private GetterUserEJB getterUserEJB;

    @GET
    public void asyncUser(@Suspended AsyncResponse response) {
        try {
            Future<UserAsyncEjb> result = getterUserEJB.getUser();
            while (!result.isDone()) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException ie) {
                    System.err.println("" + ie.getMessage());
                    response.resume(Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                            .entity(ie.getMessage()).build());
                }
            }
            response.resume(Response.ok(result.get()).build());
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("" + e.getMessage());
            response.resume(Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e.getMessage()).build());
        }
    }
}
