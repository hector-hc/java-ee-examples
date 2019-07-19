/*
* Classname:    WSAsyncCompletableFutureForecast01.java
* Author:       Héctor Hernández Chávez
* Date:         19-jul-2019
*/
package javaee.examples.jaxrs.async.completablefuture.client;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import javaee.examples.jaxrs.async.completablefuture.client.Forecast;
import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Héctor Hernández Chávez
 */
@Path("async-completable-future/forecast01")
public class WSAsyncCompletableFutureForecast01 {

    @Resource
    ManagedExecutorService executor;
    
    @GET
    public void asyncService(@Suspended AsyncResponse response) {
        CompletableFuture.supplyAsync(() -> getForecast(), executor).thenAccept(u -> {
            response.resume(Response.ok(u, MediaType.APPLICATION_JSON).build());
        }).exceptionally(t -> {
            response.resume(Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(t).build());
            return null;
        });
    }
    
    private Forecast getForecast() {
        Forecast forecast = new Forecast();
        try {
            TimeUnit.SECONDS.sleep(5);
            forecast.setForecast("10");
        } catch (InterruptedException ie) {
            System.err.println("InterruptedException " + ie);
            forecast.setForecast("-1");
        }
        return forecast;
    } 
}
