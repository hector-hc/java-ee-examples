/*
* Classname:    EventsResource.java
* Author:       Héctor Hernández Chávez
* Date:         16-jul-2019
*/
package javaee.examples.jaxrs.sse.broadcaster.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.PostConstruct;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.enterprise.event.Observes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.sse.OutboundSseEvent;
import javax.ws.rs.sse.Sse;
import javax.ws.rs.sse.SseBroadcaster;
import javax.ws.rs.sse.SseEventSink;

/**
 * @author Héctor Hernández Chávez
 */
@Path("sse/broadcaster-simple")
@Singleton
public class EventsResource {

    @Context
    private Sse sse;
    
    private volatile SseBroadcaster sseBroadcaster;
    
    private final AtomicInteger id = new AtomicInteger(1);
    
    private final List<String> messages = new ArrayList<>();
    
    @PostConstruct
    private void init() {
        sseBroadcaster = sse.newBroadcaster();
        sseBroadcaster.onError((client, exception) -> {
            System.out.println("client: " + client + ", exception: " + exception);
        });
    }
    
    @GET
    @Path("register")
    @Produces(MediaType.SERVER_SENT_EVENTS)
    public void registerSseBroadcaster(@Context SseEventSink eventSink, @HeaderParam(HttpHeaders.LAST_EVENT_ID_HEADER) @DefaultValue("-1") int lastEventId) {
        eventSink.send(sse.newEvent("Thanks for registering"));
        if (lastEventId >= 0) {
            replayLastMessage(lastEventId, eventSink);
        }
        sseBroadcaster.register(eventSink);
    }
    
    private void replayLastMessage(int lastEventId, SseEventSink eventSink) {
        try {
            for (int i = lastEventId; i < messages.size(); i++) {
                eventSink.send(createEvent(messages.get(i), i + 1));
            }
        } catch (Exception e) {
            throw new InternalServerErrorException("Could not replay messages ", e);
        }
    }
    
    private OutboundSseEvent createEvent(String message, int id) {
        return sse.newEventBuilder().id(String.valueOf(id)).data(message).build();
    }
    
    @Lock(LockType.WRITE)
    public void onEvent(@Observes DomainEvent domainEvent) {
        String message = domainEvent.getContents();
        messages.add(message);
        OutboundSseEvent event = createEvent(message, id.getAndIncrement());
        sseBroadcaster.broadcast(event);
    }
}
