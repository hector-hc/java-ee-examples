
/**
 * @Class WSUserCDI
 * @author Hector
 * @Created on Jun 22, 2019, 7:47:38 PM
 */

package javaee.examples.jaxrs.cdi.ws;

import javaee.examples.jaxrs.cdi.UserCDI;
import javaee.examples.jaxrs.cdi.UserEJB;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("usercdi")
public class WSUserCDI {

    @Inject
    private UserEJB userEjb;
    
    private UserCDI userCdiLocal;
    
    @Inject
    private void setUserCdiLocal() {
        long ts = System.currentTimeMillis();
        userCdiLocal = new UserCDI("Local " + ts, ts + "@gmail.com");
    }
    
    @GET
    @Path("from-ejb")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getUserFromEJB() {
        return Response.ok(userEjb.getUserCDI()).build();
    }
    
    @GET
    @Path("from-local")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getUserFromLocal() {
        return Response.ok(userCdiLocal).build();
    }
}
