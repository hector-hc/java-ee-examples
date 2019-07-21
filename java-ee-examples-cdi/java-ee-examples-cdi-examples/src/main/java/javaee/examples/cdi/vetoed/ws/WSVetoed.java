
/**
 * @Class WSVetoed
 * @author Hector
 * @Created on Jul 21, 2019, 2:38:22 PM
 */

package javaee.examples.cdi.vetoed.ws;

import javaee.examples.cdi.vetoed.Greeting;
import javax.inject.Inject;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("vetoed")
public class WSVetoed {
    
    @Inject
    Greeting greeting;

    @GET
    public Response getGreet(@QueryParam("name") @DefaultValue("Java") String name) {
        return Response.ok(greeting.greet(name)).build();
    }
}
