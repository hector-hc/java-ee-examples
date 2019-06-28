/*
* Classname:    WSAsyncStatus.java
* Author:       Héctor Hernández Chávez
* Date:         28-jun-2019
*/
package javaee.examples.jaxrs.async.status.ws;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import javaee.examples.jaxrs.async.status.AsyncTaskStatus;
import javaee.examples.jaxrs.async.status.UserAsyncStatus;
import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Response;

/**
 * @author Héctor Hernández Chávez
 */
@Path("async-status")
public class WSAsyncStatus {

    @Resource
    ManagedExecutorService executor;
    
    @GET
    public void asyncService(@Suspended AsyncResponse response) {
        int i = 0;
        List<UserAsyncStatus> userdFound = new ArrayList<>();
        while (i < 4) {
            Future<UserAsyncStatus> result = executor.submit(new AsyncTaskStatus());
            while (!result.isDone()) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException ie) {
                    System.err.println("" + ie.getMessage());
                }
            }
            
            try {
                userdFound.add(result.get());
            } catch (InterruptedException | ExecutionException e) {
                System.err.println("" + e.getMessage());
            }
            i++;
        }
        response.resume(Response.ok(userdFound).build());
    }
}
