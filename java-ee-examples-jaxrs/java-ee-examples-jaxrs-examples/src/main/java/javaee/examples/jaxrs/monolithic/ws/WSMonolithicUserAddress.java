
/**
 * @Class WSUserAddress
 * @author Hector
 * @Created on Jun 24, 2019, 8:25:32 AM
 */

package javaee.examples.jaxrs.monolithic.ws;

import java.net.URI;
import javaee.examples.jaxrs.monolithic.ejbs.MonolithicUserAddressEJB;
import javaee.examples.jaxrs.monolithic.entities.MonolithicUserAddress;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("monolitic/user-address")
public class WSMonolithicUserAddress {

    @EJB
    private MonolithicUserAddressEJB userAddressEJB;
    
    @GET
    @Path("{id: \\d+}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(userAddressEJB.findById(id)).build();
    }
    
    @GET
    @Path("all")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getAll() {
        return Response.ok(userAddressEJB.getAll()).build();
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response add(@Context UriInfo uriInfo, MonolithicUserAddress userAddress) {
        Long id = userAddressEJB.add(userAddress);
        URI uri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(id)).build();
        return Response.created(uri).build();
    }
    
    @DELETE
    @Path("{id: \\d+}")
    public Response remove(@PathParam("id") Long id) {
        userAddressEJB.remove(userAddressEJB.findById(id));
        return Response.noContent().build();
    }
}
