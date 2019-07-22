
/**
 * @Class WSRegex
 * @author Hector
 * @Created on Jul 21, 2019, 7:26:10 PM
 */

package javaee.examples.bean.validation.regex.ws;

import java.util.Date;
import javaee.examples.bean.validation.regex.Customer;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("regex")
public class WSRegex {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomer() {
        Customer customer = new Customer("hector", "hernandez", "hector@gmail.com", "hector@gmai..com", "12345678", new Date(), new Date());
        return Response.ok(customer).build();
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response createCustomer(@Valid Customer customer) {
        return Response.ok().build();
    }
}
