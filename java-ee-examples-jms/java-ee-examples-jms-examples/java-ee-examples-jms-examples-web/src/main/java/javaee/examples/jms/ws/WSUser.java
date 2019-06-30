
/**
 * @Class WSUser
 * @author Hector
 * @Created on Jun 30, 2019, 8:59:56 AM
 */

package javaee.examples.jms.ws;

import java.util.Date;
import javaee.examples.jms.model.User;
import javaee.examples.jms.senders.UserSenderJMS;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;

@Path("user")
public class WSUser {

    @Inject
    private UserSenderJMS senderJMS;
    
    @GET
    @Path("send")
    public void sendUserMessage(@Suspended AsyncResponse response) {
        long id = new Date().getTime();
        senderJMS.send(new User(id, "User_" + id));
        response.resume("Message sent to the queue");
    }
}
