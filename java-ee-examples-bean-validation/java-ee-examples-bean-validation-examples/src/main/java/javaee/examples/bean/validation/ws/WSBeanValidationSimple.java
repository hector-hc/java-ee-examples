
/**
 * @Class WSBeanValidationSimple
 * @author Hector
 * @Created on Jun 14, 2019, 9:30:50 AM
 */

package javaee.examples.bean.validation.ws;

import javaee.examples.bean.validation.simple.User;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("bean-validation/simple")
public class WSBeanValidationSimple {
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response validUser(@Valid User user) {
        return Response.accepted().build();
    }
}
