
/**
 * @Class WSUserRemote
 * @author Hector
 * @Created on Jun 30, 2019, 12:52:24 PM
 */

package javaee.examples.jaxrs.async.callback.ws;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import javaee.examples.jaxrs.async.callback.UserAsyncCallback;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("callback/user")
public class WSCallbackUser {

    @GET
    public Response getRemoteUser() {
        long id = new Date().getTime();
        try {
            TimeUnit.SECONDS.sleep(5);
            return Response.ok(new UserAsyncCallback(id, "User_" + id)).build();
        } catch (InterruptedException ie) {
            System.err.println("" + ie.getMessage());
            return Response.ok(new UserAsyncCallback(id, "Error_" + id)).build();
        }
    }
}
