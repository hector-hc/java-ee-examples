
/**
 * @Class WSProducesPrimitives
 * @author Hector
 * @Created on Jul 21, 2019, 2:24:38 PM
 */

package javaee.examples.cdi.producers.primitves.ws;

import java.util.logging.Logger;
import javaee.examples.cdi.producers.primitves.IntValue;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("produces/primitves")
public class WSProducesPrimitives {

    //@Inject
    //private Logger logger;
    
    @Inject @IntValue
    private int initialValue;
    
    @GET
    public Response getInitialValue() {
        //logger.entering("WSProducesPrimitives", "getInitialValue");
        return Response.ok(initialValue).build();
    }
}
