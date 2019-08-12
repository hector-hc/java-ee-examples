
/**
 * @Class WSEventAsync
 * @author Hector
 * @Created on Jun 29, 2019, 10:41:16 AM
 */

package javaee.examples.cdi.events.async.simple.ws;

import java.util.Date;
import java.util.concurrent.CompletionStage;
import javaee.examples.cdi.events.async.simple.User;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.enterprise.event.ObservesAsync;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Response;

@Path("event-async/user")
public class WSEventAsync {

    @Inject
    private Event<User> event;
    
    private AsyncResponse reponse;
    
    @GET
    public void asyncService(@Suspended AsyncResponse response) {
        long id = new Date().getTime();
        this.reponse = response;
        CompletionStage<User> r = event.fireAsync(new User(id, "User_" + id));
    }
    
    public void onFireEvent(@ObservesAsync User user) {
        reponse.resume(Response.ok(user).build());
    }
}
