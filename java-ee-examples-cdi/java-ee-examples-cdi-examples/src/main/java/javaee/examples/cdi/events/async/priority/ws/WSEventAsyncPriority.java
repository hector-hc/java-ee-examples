
/**
 * @Class WSEventAsyncPriority
 * @author Hector
 * @Created on Jun 29, 2019, 12:08:09 PM
 */

package javaee.examples.cdi.events.async.priority.ws;

import java.util.Arrays;
import java.util.concurrent.CompletionStage;
import javaee.examples.cdi.events.async.priority.BookEvent;
import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.event.Event;
import javax.enterprise.event.NotificationOptions;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("event-async-priority")
public class WSEventAsyncPriority {
    
    @Inject
    private Event<BookEvent> events;

    @Resource
    ManagedExecutorService executorService;
    
    @GET
    public Response doRequestAsync() {
        BookEvent bookEvent = new BookEvent();
        bookEvent.setNotifyList(Arrays.asList("1", "2", "3", "4", "5"));
        CompletionStage<?> result = events.fireAsync(bookEvent, NotificationOptions.ofExecutor(executorService));
        System.out.println("finish method doRequestAsync: " + result);
        return Response.ok().entity("OK").build();
    }
}
