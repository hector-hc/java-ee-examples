/*
* Classname:    WSCompletionStageUser.java
* Author:       Héctor Hernández Chávez
* Date:         17-jul-2019
*/
package javaee.examples.jaxrs.async.completionstage.ws;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import javaee.examples.jaxrs.async.completionstage.User;
import javaee.examples.jaxrs.async.completionstage.UserStore;
import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Héctor Hernández Chávez
 */
@Path("completion-stage/user")
public class WSCompletionStageUser {

    @Resource
    ManagedExecutorService mes;
    
    @Inject
    UserStore userStorage;
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public CompletionStage<Response> createUserAsync(@Valid User user) {
        return CompletableFuture.supplyAsync(() -> createUser(user), mes);
    }
    
    private Response createUser(User user) {
        userStorage.create(user);
        return Response.accepted().build();
    }
}
