
/**
 * @Class WSInstanceQualifiers
 * @author Hector
 * @Created on Jul 21, 2019, 1:55:35 PM
 */

package javaee.examples.cdi.instance.qualifiers.ws;

import javaee.examples.cdi.instance.qualifiers.Business;
import javaee.examples.cdi.instance.qualifiers.GreetingInstanceQualifier;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Instance;
import javax.enterprise.util.AnnotationLiteral;
import javax.inject.Inject;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("instance/qualifier")
public class WSInstanceQualifiers {

    @Inject @Any
    Instance<GreetingInstanceQualifier> greetingInstance;
    
    @GET
    public Response getGreetInstanceQualifier(@QueryParam("name") @DefaultValue("Java") String name) {
        StringBuilder message = new StringBuilder();
        
        Instance<GreetingInstanceQualifier> businessInstance = greetingInstance.select(new AnnotationLiteral<Business>() {});
        GreetingInstanceQualifier insGreetingBusiness = businessInstance.get();
        message.append(insGreetingBusiness.greet(name));
        businessInstance.destroy(insGreetingBusiness);
        
        message.append(" || ");
        
        Instance<GreetingInstanceQualifier> defaultInstance = greetingInstance.select(new AnnotationLiteral<Default>() {});
        GreetingInstanceQualifier insGreetingDefault = defaultInstance.get();
        message.append(insGreetingDefault.greet(name));
        defaultInstance.destroy(insGreetingDefault);
        
        return Response.ok(message.toString()).build();
    }
}
