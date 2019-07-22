
/**
 * @Class WSBeanValidationMethod
 * @author Hector
 * @Created on Jul 21, 2019, 7:20:43 PM
 */

package javaee.examples.bean.validation.method.ws;

import javaee.examples.bean.validation.method.CardValidator;
import javax.inject.Inject;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("method")
public class WSBeanValidationMethod {
    
    @Inject
    CardValidator cardValidator;

    @GET
    public Response validateMethod(@QueryParam("number") @DefaultValue("1234") String number) {
        cardValidator.isValid(number);
        return Response.ok().build();
    }
}
