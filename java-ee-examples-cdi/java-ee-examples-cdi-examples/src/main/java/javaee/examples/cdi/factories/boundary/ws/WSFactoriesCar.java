
/**
 * @Class WSFactoriesCar
 * @author Hector
 * @Created on Jul 14, 2019, 8:35:38 PM
 */

package javaee.examples.cdi.factories.boundary.ws;

import javaee.examples.cdi.factories.boundary.CarEnthusiast;
import javaee.examples.cdi.factories.entity.GermanCar;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("factories/car")
public class WSFactoriesCar {
    
    @Inject
    CarEnthusiast carEnthusist;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBMWCar() {
        GermanCar car = carEnthusist.getBMWCar();
        return Response.ok(car.toString()).build();
    }
}
