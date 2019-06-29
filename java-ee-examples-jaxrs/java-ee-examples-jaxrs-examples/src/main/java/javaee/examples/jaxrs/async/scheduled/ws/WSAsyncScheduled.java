
/**
 * @Class WSAsyncScheduled
 * @author Hector
 * @Created on Jun 29, 2019, 9:31:32 AM
 */

package javaee.examples.jaxrs.async.scheduled.ws;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javaee.examples.jaxrs.async.scheduled.AsyncTaskScheduled;
import javaee.examples.jaxrs.async.scheduled.UserAsyncScheduled;
import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedScheduledExecutorService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Response;

@Path("async-scheduled")
public class WSAsyncScheduled {

    @Resource
    ManagedScheduledExecutorService executor;
    
    @GET
    public void asyncService(@Suspended AsyncResponse response) {
        ScheduledFuture<UserAsyncScheduled> result = executor.schedule(
                new AsyncTaskScheduled(), 5, TimeUnit.SECONDS);
        while (!result.isDone()) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ie) {
                System.err.println("" + ie.getMessage());
            }
        }
        try {
            response.resume(Response.ok(result.get()).build());
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("" + e.getMessage());
            response.resume(Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e.getMessage()).build());
        }
    }
}
