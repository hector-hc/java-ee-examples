
/**
 * @Class SseResource
 * @author Hector
 * @Created on Jun 14, 2019, 5:57:12 PM
 */

package javaee.examples.jaxrs.sse.simple;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;
import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.sse.OutboundSseEvent;
import javax.ws.rs.sse.Sse;
import javax.ws.rs.sse.SseEventSink;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("sse")
public class SseResource {
    
    public static final Logger LOGGER = LoggerFactory.getLogger(SseResource.class);
    
    @Resource
    ManagedExecutorService executorService;
    
    @GET
    @Produces(MediaType.SERVER_SENT_EVENTS)
    public void getServerSentEvents(@Context SseEventSink eventSink, @Context Sse sse) {
        executorService.submit(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException ie) {
                    LOGGER.error("Interrupted Exception ", ie);
                }
                final OutboundSseEvent event = sse.newEventBuilder()
                        .name("message-to-client").data(String.class, "Hello Word " + i + "!")
                        .build();
                eventSink.send(event);
            }
        });
        
        
        /*new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException ie) {
                    LOGGER.error("InterruptedException ", ie);
                }
                final OutboundSseEvent event = sse.newEventBuilder()
                        .name("message-to-client").data(String.class, "Hello Word " + i + "!").build();
                eventSink.send(event);
            }
        }).start();*/
    }
}
