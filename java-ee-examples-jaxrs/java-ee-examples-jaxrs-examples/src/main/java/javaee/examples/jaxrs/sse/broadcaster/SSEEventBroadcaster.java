
/**
 * @Class SSEEventBroadcaster
 * @author Hector
 * @Created on Jun 22, 2019, 8:21:45 AM
 */

package javaee.examples.jaxrs.sse.broadcaster;

import java.util.UUID;
import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.sse.Sse;
import javax.ws.rs.sse.SseBroadcaster;
import javax.ws.rs.sse.SseEventSink;

@Singleton
@Path("ssebroadcaster")
public class SSEEventBroadcaster {

    @Context
    private Sse sse;
    
    private volatile SseBroadcaster sseBroadcaster;
    
    @PostConstruct
    public void init() {
        sseBroadcaster = sse.newBroadcaster();
    }
    
    @GET
    @Path("register")
    @Produces(MediaType.SERVER_SENT_EVENTS)
    public void registerSseBroadcaster(@Context SseEventSink eventSink) {
        eventSink.send(sse.newEvent("Thanks for registering"));
        sseBroadcaster.register(eventSink);
    }
    
    @GET
    @Path("send/{message}")
    public void broadcaster(@PathParam("message") String message) {
        sseBroadcaster.broadcast(sse.newEventBuilder().mediaType(MediaType.APPLICATION_JSON_TYPE)
        .id(UUID.randomUUID().toString()).name("SSEventBroadcaster message").data(message).build());
    }
}
