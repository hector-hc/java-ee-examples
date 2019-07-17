
/**
 * @Class WSAsyncManaged
 * @author Hector
 * @Created on Jun 29, 2019, 9:06:32 AM
 */

package javaee.examples.jaxrs.async.managed.ws;

import javaee.examples.jaxrs.async.managed.UserAsyncManagedService;
import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedThreadFactory;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Response;

@Path("async-managed")
public class WSAsyncManagedUser {
    
    @Inject
    UserAsyncManagedService asyncService;

    @Resource
    ManagedThreadFactory factory;
    
    @GET
    public void asyncService(@Suspended AsyncResponse response) {
        Thread thread = factory.newThread(() -> {
            response.resume(Response.ok(asyncService.getUser()).build());
        });
        thread.setName("Managed Async Task");
        thread.setPriority(Thread.MIN_PRIORITY);
        thread.start();
    }
}
