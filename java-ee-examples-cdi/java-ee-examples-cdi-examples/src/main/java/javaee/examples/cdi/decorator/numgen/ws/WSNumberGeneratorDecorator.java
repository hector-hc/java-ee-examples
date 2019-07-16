/*
* Classname:    WSNumberGeneratorDecorator.java
* Author:       Héctor Hernández Chávez
* Date:         16-jul-2019
*/
package javaee.examples.cdi.decorator.numgen.ws;

import javaee.examples.cdi.decorator.numgen.NumberGenerator;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Héctor Hernández Chávez
 */
@Path("decorator/numgen")
public class WSNumberGeneratorDecorator {

    @Inject
    private NumberGenerator numberGenerator;
    
    @GET
    @Produces({MediaType.TEXT_PLAIN})
    public Response numberGenerator() {
        return Response.ok(numberGenerator.generateNumber()).build();
    }
}
