
/**
 * @Class WSEventAsync
 * @author Hector
 * @Created on Jun 29, 2019, 11:07:57 AM
 */

package javaee.examples.cdi.events.async.executor.ws;

import java.util.Arrays;
import javaee.examples.cdi.events.async.executor.BookEvent;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.event.Event;
import javax.enterprise.event.NotificationOptions;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Stateless
@Path("event-async/book")
public class WSEventAsync {

    @Inject
    private Event<BookEvent> onlineSaleEvent;
    
    @Resource
    ManagedExecutorService executorService;
    
    @GET
    @Path("without-executor")
    public Response doRequestAsyncWithoutExecutor() {
        BookEvent bookEvent = new BookEvent();
        bookEvent.setNotifyList(Arrays.asList("1", "2", "3", "4", "5"));
        onlineSaleEvent.fireAsync(bookEvent);
        System.out.println("finish method doRequestAsyncWithoutExecutor");
        return Response.ok().entity("OK").build();
    }
    
    @GET
    @Path("with-executor")
    public Response doRequestAsyncWithExecutor() {
        BookEvent bookEvent = new BookEvent();
        bookEvent.setNotifyList(Arrays.asList("1", "2", "3", "4", "5"));
        onlineSaleEvent.fireAsync(bookEvent, NotificationOptions.ofExecutor(executorService));
        System.out.println("finish method doRequestAsyncWithoutExecutor");
        return Response.ok().entity("OK").build();
    }
}
