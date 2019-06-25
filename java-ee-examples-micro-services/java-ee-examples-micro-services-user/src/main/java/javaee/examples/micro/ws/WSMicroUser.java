
/**
 * @Class WSMicroUser
 * @author Hector
 * @Created on Jun 24, 2019, 8:18:00 PM
 */

package javaee.examples.micro.ws;

import javaee.examples.micro.entities.MicroUser;
import javaee.examples.micro.services.UserService;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("micro-user")
public class WSMicroUser {

    @Inject
    UserService userService;
    
    @GET
    @Path("{id: \\d+}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(userService.find(id)).build();
    }
    
    @GET
    @Path("all")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response findAll() {
        return Response.ok(userService.findAll()).build();
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response add(MicroUser microUser) {
        userService.create(microUser);
        return Response.accepted().build();
    }
    
    @DELETE
    @Path("{id: \\d+}")
    public Response remove(@PathParam("id") Long id) {
        userService.remove(userService.find(id));
        return Response.noContent().build();
    }
}
