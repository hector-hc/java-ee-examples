/*
* Classname:    WSAsyncTx.java
* Author:       Héctor Hernández Chávez
* Date:         26-jun-2019
*/
package javaee.examples.jaxrs.async.tx.ws;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import javaee.examples.jaxrs.async.tx.AsyncTask;
import javaee.examples.jaxrs.async.tx.UserAsyncTx;
import javax.annotation.PostConstruct;
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
@Path("async-tx")
public class WSAsyncTx {

    private AsyncTask asyncTask;
    
    @Resource
    private ManagedExecutorService executor;
    
    @PostConstruct
    public void init() {
        asyncTask = new AsyncTask();
    }
    
    @GET
    public void getUserAsyncTx(@Suspended AsyncResponse response) {
        Future<UserAsyncTx> result = executor.submit(asyncTask);
        
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
            response.resume(Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build());
        }
    }
}
