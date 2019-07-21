
/**
 * @Class GreetingReceiverConditional
 * @author Hector
 * @Created on Jul 21, 2019, 1:20:41 PM
 */

package javaee.examples.cdi.events.conditional.ws;

import javaee.examples.cdi.events.conditional.EventReceiverConditional;
import javaee.examples.cdi.events.conditional.EventSenderConditional;
import javax.inject.Inject;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("events/conditional")
public class WSEventsConditional {
    @Inject
    EventSenderConditional senderConditional;
    
    @Inject
    EventReceiverConditional receiverConditional;
    
    @GET
    public Response doRequestEventConditional(@QueryParam("text") @DefaultValue("Java") String text) {
        senderConditional.sent(text);
        return Response.ok(receiverConditional.getGreet()).build();
    }
}
