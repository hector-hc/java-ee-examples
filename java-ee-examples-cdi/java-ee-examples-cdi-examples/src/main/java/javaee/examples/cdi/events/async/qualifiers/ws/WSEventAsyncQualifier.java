
/**
 * @Class WSEventAsyncQualifier
 * @author Hector
 * @Created on Jun 29, 2019, 12:21:34 PM
 */

package javaee.examples.cdi.events.async.qualifiers.ws;

import java.util.Arrays;
import javaee.examples.cdi.events.async.qualifiers.BookEvent;
import javaee.examples.cdi.events.async.qualifiers.OnlineSale;
import javaee.examples.cdi.events.async.qualifiers.StoreSale;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("event-async-qualifier")
public class WSEventAsyncQualifier {
    
    @Inject @OnlineSale
    private Event<BookEvent> onlineSaleEvent;
    
    @Inject @StoreSale
    private Event<BookEvent> onStoreSaleEvent;
    
    @GET
    @Path("online")
    public Response doRequestAsyncOnline() {
        BookEvent bookEvent = new BookEvent();
        bookEvent.setNotifyList(Arrays.asList("1", "2", "3", "4", "5"));
        onlineSaleEvent.fireAsync(bookEvent);
        System.out.println("finish method doRequestAsync");
        return Response.ok().entity("OK").build();
    }
    
    @GET
    @Path("onstore")
    public Response doRequestAsyncOnStore() {
        BookEvent bookEvent = new BookEvent();
        bookEvent.setNotifyList(Arrays.asList("1", "2", "3", "4", "5"));
        onStoreSaleEvent.fireAsync(bookEvent);
        System.out.println("finish method doRequestAsync");
        return Response.ok().entity("OK").build();
    }
}
