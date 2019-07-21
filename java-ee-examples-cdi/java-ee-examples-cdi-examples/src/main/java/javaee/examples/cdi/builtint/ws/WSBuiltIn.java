
/**
 * @Class WSBuiltIn
 * @author Hector
 * @Created on Jul 20, 2019, 9:56:59 PM
 */

package javaee.examples.cdi.builtint.ws;

import java.security.Principal;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("built-in")
public class WSBuiltIn {

    @Inject
    private HttpServletRequest httpServletRequest;
    
    @Inject
    private  HttpSession httpSession;
    
    @Inject
    private ServletContext servletContext;
    
    @Inject
    private UserTransaction userTransaction;
    
    @Inject
    private Principal principal;
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getResponseBuiltIn() {
        StringBuilder sb = new StringBuilder();
        sb.append("context path (HttpServletRequest): ").append(httpServletRequest.getContextPath()).append("\n");
        sb.append("session id: ").append(httpSession.getId()).append("\n");
        sb.append("context path (ServletContext): ").append(servletContext.getContextPath()).append("\n");
        try {
            sb.append("user transaction status: ").append(userTransaction.getStatus()).append("\n");
        } catch (Exception e) {
            throw new WebApplicationException(e.getMessage());
        }
        sb.append("secutiry principal: ").append(principal.getName()).append("\n");
        return Response.ok(sb.toString()).build();
    }
}
