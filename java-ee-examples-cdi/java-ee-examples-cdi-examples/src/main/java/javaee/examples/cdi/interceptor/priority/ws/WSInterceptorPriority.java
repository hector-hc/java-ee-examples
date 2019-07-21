
/**
 * @Class WSInterceptorPriority
 * @author Hector
 * @Created on Jul 21, 2019, 2:14:36 PM
 */

package javaee.examples.cdi.interceptor.priority.ws;

import javaee.examples.cdi.interceptor.priority.GreetingInterceptorPriority;
import javax.inject.Inject;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("interceptor/priority")
public class WSInterceptorPriority {

    @Inject
    GreetingInterceptorPriority greeting;
    
    @GET
    public Response getGreet(@QueryParam("name") @DefaultValue("Java") String name) {
        greeting.setGreet(name);
        return Response.ok(greeting.getGreet()).build();
    }
}
