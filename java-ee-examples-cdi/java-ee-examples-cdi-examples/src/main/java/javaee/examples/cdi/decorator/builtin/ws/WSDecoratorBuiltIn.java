
/**
 * @Class WSDecoratorBuiltIn
 * @author Hector
 * @Created on Jul 20, 2019, 9:47:10 PM
 */

package javaee.examples.cdi.decorator.builtin.ws;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("built-in/http-servlet-request")
public class WSDecoratorBuiltIn {

    @Inject
    private HttpServletRequest httpServletRequest;
    
    @GET
    public Response getParamterName(@QueryParam("name") @DefaultValue("Java") String name) {
        System.out.println("context path (HttpServletRequest): " + httpServletRequest.getContextPath());
        return Response.ok(httpServletRequest.getParameter(name)).build();
    }
}
