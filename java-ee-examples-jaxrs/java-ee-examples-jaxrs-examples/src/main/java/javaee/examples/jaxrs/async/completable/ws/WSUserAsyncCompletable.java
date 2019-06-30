
/**
 * @Class WSUserAsyncCompletable
 * @author Hector
 * @Created on Jun 30, 2019, 1:33:20 PM
 */

package javaee.examples.jaxrs.async.completable.ws;

import java.util.concurrent.CompletableFuture;
import javaee.examples.jaxrs.async.completable.UserAsyncCompletableFutureService;
import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Response;

@Path("async-completable")
public class WSUserAsyncCompletable {

    @Inject
    UserAsyncCompletableFutureService asyncService;
    
    @Resource
    ManagedExecutorService executor;
    
    @GET
    public void asyncService(@Suspended AsyncResponse response) {
        CompletableFuture.supplyAsync(() -> asyncService.getUser(), executor).thenAcceptAsync(u -> {
            response.resume(Response.ok(u).build());
        }).exceptionally(t -> {
            response.resume(Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(t).build());
            return null;
        });
    }
}
