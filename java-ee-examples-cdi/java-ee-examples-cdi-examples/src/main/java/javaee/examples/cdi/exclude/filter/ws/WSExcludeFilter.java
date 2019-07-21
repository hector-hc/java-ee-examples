
/**
 * @Class WSExcludeFilter
 * @author Hector
 * @Created on Jul 21, 2019, 1:34:47 PM
 */

package javaee.examples.cdi.exclude.filter.ws;

import javaee.examples.cdi.exclude.filter.GreetingExcludeFilter;
import javax.inject.Inject;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("exclude-filter")
public class WSExcludeFilter {

    @Inject
    GreetingExcludeFilter excludeFilter;
    
    @GET
    public Response getGreet(@QueryParam("name") @DefaultValue("Java") String name) {
        return Response.ok(excludeFilter.greet(name)).build();
    }
}
