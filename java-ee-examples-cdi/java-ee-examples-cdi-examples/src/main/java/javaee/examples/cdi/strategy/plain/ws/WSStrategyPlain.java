/*
* Classname:    WSStrategyPlain.java
* Author:       Héctor Hernández Chávez
* Date:         16-jul-2019
*/
package javaee.examples.cdi.strategy.plain.ws;

import java.util.function.Function;
import javaee.examples.cdi.strategy.plain.Greeter;
import javax.inject.Inject;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 * @author Héctor Hernández Chávez
 */
@Path("strategy/plain")
public class WSStrategyPlain {

    @Inject
    Greeter greeter;
    
    @GET
    public Response greeting(@QueryParam("name") @DefaultValue("Java") String name) {
        Function<String, String> formalGreeting = n -> "Dear " + n;
        Function<String, String> informalGreeting = n -> "Hey " + n;
        greeter.setStrategy(formalGreeting);
        return Response.ok(greeter.greet(name)).build();
    }
}
