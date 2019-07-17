/*
* Classname:    WSBeanValidationUser.java
* Author:       Héctor Hernández Chávez
* Date:         16-jul-2019
*/
package javaee.examples.jaxrs.bean.validation.ws;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import javaee.examples.jaxrs.bean.validation.User;
import javaee.examples.jaxrs.bean.validation.UserStore;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * @author Héctor Hernández Chávez
 */
@Path("bean-validation/user")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class WSBeanValidationUser {

    @Inject
    UserStore userStore;
    
    @Context
    UriInfo uriInfo;
    
    @GET
    public List<User> getUsers() {
        return userStore.getUsers();
    }
    
    @GET
    @Path("{id: \\d+}")
    public User getUserById(@PathParam("id") long id) {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException ie) {
            System.err.println("InterruptedException " + ie);
        }
        Optional<User> optUser = userStore.getByUserId(id);
        if (optUser.isPresent()) {
            return optUser.get();
        } else {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
    }
    
    @POST
    public Response createUser(@Valid @NotNull User user) {
        User userCreated = userStore.addUser(user);
        URI userUri = uriInfo.getBaseUriBuilder().path(WSBeanValidationUser.class)
                .path(WSBeanValidationUser.class, "getUserById").build(userCreated.getId());
        return Response.created(userUri).build();
    }
}
