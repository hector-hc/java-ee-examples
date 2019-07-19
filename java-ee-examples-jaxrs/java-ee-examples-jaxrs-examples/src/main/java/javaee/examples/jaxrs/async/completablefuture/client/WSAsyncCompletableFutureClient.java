/*
* Classname:    WSAsyncCompletableFutureClient.java
* Author:       Héctor Hernández Chávez
* Date:         19-jul-2019
*/
package javaee.examples.jaxrs.async.completablefuture.client;

import javaee.examples.jaxrs.async.completablefuture.client.CompletableFutureWeatherForecast;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Héctor Hernández Chávez
 */
@Path("async-completable-future/forecast/client")
public class WSAsyncCompletableFutureClient {

    @Inject
    CompletableFutureWeatherForecast weatherForecast;
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAvergareForecast() {
        return Response.ok(this.weatherForecast.getAverageForecast()).build();
    }
}
