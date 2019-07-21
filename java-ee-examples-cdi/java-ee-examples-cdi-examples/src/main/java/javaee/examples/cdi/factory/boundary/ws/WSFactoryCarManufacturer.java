
/**
 * @Class WSCarManufacturer
 * @author Hector
 * @Created on Jul 14, 2019, 7:44:13 PM
 */

package javaee.examples.cdi.factory.boundary.ws;

import javaee.examples.cdi.factory.boundary.CarManufacturer;
import javaee.examples.cdi.factory.entity.Car;
import javaee.examples.cdi.factory.entity.Color;
import javaee.examples.cdi.factory.entity.EngineType;
import javaee.examples.cdi.factory.entity.Specification;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("factory/car/manufacturer")
public class WSFactoryCarManufacturer {

    @Inject
    CarManufacturer carManufacturer;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCar(Specification spec) {
        Car car = carManufacturer.manufactureCar(spec);
        return Response.ok(car).build();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSpecification() {
        Specification spec = new Specification();
        spec.setEngine(EngineType.DISEL);
        spec.setColor(Color.BLACK);
        return Response.ok(spec).build();
    }
    
    @GET
    @Path("{id: \\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCarById(@PathParam("id") Integer id) {
        Car car = carManufacturer.getCarById(id);
        return Response.ok(car).build();
    }
}
