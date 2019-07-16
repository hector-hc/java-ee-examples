/*
* Classname:    WSUserClient.java
* Author:       Héctor Hernández Chávez
* Date:         16-jul-2019
*/
package javaee.examples.jaxrs.bean.validation.client.ws;

import javaee.examples.jaxrs.bean.validation.User;
import javaee.examples.jaxrs.bean.validation.client.UserClient;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Héctor Hernández Chávez
 */
@Path("user/jaxrs-client")
public class WSUserClient {

    @Inject
    UserClient userClient;
    
    @GET
    @Path("{id: \\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserById(@PathParam("id") long id) {
        User user = userClient.getUserById(id);
        return Response.ok(user).build();
    }
}
