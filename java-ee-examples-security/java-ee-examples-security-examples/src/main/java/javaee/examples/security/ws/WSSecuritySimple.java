
/**
 * @Class WSSecuritySimple
 * @author Hector
 * @Created on Jun 16, 2019, 6:19:26 PM
 */

package javaee.examples.security.ws;

import javaee.examples.security.simple.AdminExecutor;
import javaee.examples.security.simple.OperatorExecutor;
import javaee.examples.security.simple.User;
import javaee.examples.security.simple.UserBean;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("security")
public class WSSecuritySimple {

    @EJB
    private UserBean userBean;
    
    @EJB
    private AdminExecutor adminExecutor;
    
    @EJB
    private OperatorExecutor operatorExecutor;
    
    @GET
    @Path("add")
    public Response addUser() throws Exception {
        adminExecutor.run(() -> {
            userBean.add(new User(1L, "user1", "user1@user.com"));
        });
        return Response.ok().entity("OK").build();
    }
    
    @GET
    @Path("add/operator")
    public Response addUserOperator() throws Exception {
        operatorExecutor.run(() -> {
            userBean.add(new User(1L, "user1", "user1@user.com"));
        });
        return Response.ok().entity("OK").build();
    }
    
    @GET
    @Path("add/anonymous")
    public Response addUserAnonymous() {
        userBean.add(new User(1L, "user1", "user1@user.com"));
        return Response.ok().entity("OK").build();
    }
}
