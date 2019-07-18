/*
* Classname:    WSMESUser.java
* Author:       Héctor Hernández Chávez
* Date:         18-jul-2019
*/
package javaee.examples.jaxrs.async.mes.ws;

import java.util.concurrent.TimeUnit;
import javaee.examples.jaxrs.async.mes.User;
import javaee.examples.jaxrs.async.mes.UserStore;
import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Response;

/**
 * @author Héctor Hernández Chávez
 */
@Path("mes/user")
public class WSMESUser {

    @Resource
    ManagedExecutorService mes;
    
    @Inject
    UserStore userStorage;
    
    @POST
    public void createUserAsync(User user, @Suspended AsyncResponse reponse) {
        reponse.setTimeout(5, TimeUnit.SECONDS);
        reponse.setTimeoutHandler(r -> r.resume(Response.status(Response.Status.SERVICE_UNAVAILABLE)));
        mes.submit(() -> reponse.resume(createUser(user)));
    }
    
    private Response createUser(User user) {
        userStorage.create(user);
        return Response.accepted().build();
    }
}
