/*
* Classname:    WSServerSentService.java
* Author:       Héctor Hernández Chávez
* Date:         21-jun-2019
*/
package javaee.examples.jaxrs.sse.broadcaster;

import java.net.URI;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.sse.Sse;
import javax.ws.rs.sse.SseEventSink;

/**
 * @author Héctor Hernández Chávez
 */
@Path("serversentservice")
public class WSServerSentService {

    private static final Map<Long, UserEvent> POOL = new ConcurrentHashMap<>();
    
    @Resource
    private ManagedExecutorService executor;
    
    @Path("start")
    @POST
    public Response start(@Context Sse sse) {
        final UserEvent process = new UserEvent(sse);
        POOL.put(process.getId(), process);
        executor.submit(process);
        final URI uri = UriBuilder.fromResource(WSServerSentService.class)
                .path("register/{id}").build(process.getId());
        return Response.created(uri).build();
    }
    
    @Path("register/{id}")
    @Produces(MediaType.SERVER_SENT_EVENTS)
    @GET
    public void register(@PathParam("id") Long id, @Context SseEventSink sseEventSink) {
        final UserEvent event = POOL.get(id);
        if (event == null) {
            throw new NotFoundException();
        } else {
            event.getSseBroadcaster().register(sseEventSink);
        }
    }
}
