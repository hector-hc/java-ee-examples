
/**
 * @Class WSAsyncService
 * @author Hector
 * @Created on Jun 29, 2019, 9:29:15 PM
 */

package javaee.examples.websockets.async.client.ws;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import javaee.examples.websockets.async.client.AsyncClient;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Response;

@Path("async-service")
@Stateless
public class WSAsyncService {

    @GET
    public void asyncService(@Suspended AsyncResponse response) {
        AsyncClient client = new AsyncClient(response);
        client.connect();
        client.send("Message from client " + new Date().getTime());
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException ie) {
            System.err.println("error:::: " + ie.getMessage());
            response.resume(Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ie.getMessage()).build());
        }
        client.close();
    }
}
