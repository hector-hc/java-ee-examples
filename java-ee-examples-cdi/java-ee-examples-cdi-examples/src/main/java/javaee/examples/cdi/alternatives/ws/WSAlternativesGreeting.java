
/**
 * @Class WSAlternativesGreeting
 * @author Hector
 * @Created on Jul 20, 2019, 8:14:54 AM
 */

package javaee.examples.cdi.alternatives.ws;

import javaee.examples.cdi.alternatives.GreetingAlternative;
import javax.inject.Inject;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("alternatives/greeting")
public class WSAlternativesGreeting {

    @Inject
    GreetingAlternative greetingAlternative;
    
    @GET
    public Response getGreeting(@QueryParam("name") @DefaultValue("Java") String name) {
        return Response.ok(greetingAlternative.greet(name)).build();
    }
}
