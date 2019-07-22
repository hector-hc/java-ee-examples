
/**
 * @Class WSBeanValidationZipCode
 * @author Hector
 * @Created on Jul 21, 2019, 7:34:49 PM
 */

package javaee.examples.bean.validation.zipcode.ws;

import javaee.examples.bean.validation.zipcode.ZipCodeBean;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("zipcode")
public class WSBeanValidationZipCode {
    
    @Inject ZipCodeBean zipcodeBean;
    
    @GET
    @Path("validate")
    public Response validateZipCode(@QueryParam("zipcode") String zipcode) {
        zipcodeBean.saveZipMexico(zipcode);
        return Response.ok().build();
    }
}
