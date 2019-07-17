/*
* Classname:    WSCalculatorAsyncMES.java
* Author:       Héctor Hernández Chávez
* Date:         17-jul-2019
*/
package javaee.examples.ejb.async.ws;

import javaee.examples.ejb.async.mes.Calculator;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Response;

/**
 * @author Héctor Hernández Chávez
 */
@Path("async/mes/calculator")
public class WSCalculatorAsyncMES {

    @EJB
    private Calculator calculator;
    
    @GET
    public void calcule(@Suspended AsyncResponse response) {
        calculator.calculateSomething().thenAcceptAsync(r -> {
            response.resume(Response.ok(r).build());
        }).exceptionally(t -> {
            response.resume(Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(t).build());
            return null;
        });
    }
}
