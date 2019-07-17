
/**
 * @Class WSAsyncProxy
 * @author Hector
 * @Created on Jun 29, 2019, 10:03:48 AM
 */

package javaee.examples.jaxrs.async.proxy.ws;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import javaee.examples.jaxrs.async.proxy.AsyncTaskProxy;
import javaee.examples.jaxrs.async.proxy.ExecutorProxy;
import javaee.examples.jaxrs.async.proxy.UserAsyncProxy;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Response;

@Path("async-proxy")
public class WSAsyncProxyUser {

    @Inject
    ExecutorProxy executor;
    
    @GET
    public void asyncService(@Suspended AsyncResponse response) {
        try {
            Future<UserAsyncProxy> result = executor.submit(new AsyncTaskProxy());
            response.resume(Response.ok(result.get()).build());
        } catch (InterruptedException | ExecutionException ie) {
            response.resume(Response.status(Response.Status.INTERNAL_SERVER_ERROR).build());
        }
    }
}
