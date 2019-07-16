/*
* Classname:    WSStrategyGreeter.java
* Author:       Héctor Hernández Chávez
* Date:         16-jul-2019
*/
package javaee.examples.cdi.strategy.greeter.ws;

import java.util.function.Function;
import javax.inject.Inject;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Héctor Hernández Chávez
 */
@Path("strategy/greeter")
public class WSStrategyGreeter {

    @Inject
    private Function<String, String> greeting;
    
    @GET
    @Produces({MediaType.TEXT_PLAIN})
    public Response greeting(@QueryParam("name") @DefaultValue("Java") String name) {
        //greeting = n -> "Dear " + n;
        return Response.ok(greeting.apply(name)).build();
    }
}
