
/**
 * @Class WSInstance
 * @author Hector
 * @Created on Jul 21, 2019, 1:46:31 PM
 */

package javaee.examples.cdi.instance.ws;

import javaee.examples.cdi.instance.GreetingInstance;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("instance")
public class WSInstance {

    @Inject
    Instance<GreetingInstance> greeting;
    
    @GET
    public Response getGreetOfAllInstances(@QueryParam("name") @DefaultValue("Java") String name) {
        StringBuilder message = new StringBuilder();
        greeting.stream().forEach(i -> message.append(i.greet(name)));
        return Response.ok(message.toString()).build();
    }
}
