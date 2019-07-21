/*
* Classname:    WSCarMunufacturerConfig.java
* Author:       Héctor Hernández Chávez
* Date:         17-jul-2019
*/
package javaee.examples.cdi.decorator.configuration.ws;

import javaee.examples.cdi.decorator.configuration.Car;
import javaee.examples.cdi.decorator.configuration.CarManufacturer;
import javaee.examples.cdi.decorator.configuration.Specification;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Héctor Hernández Chávez
 */
@Path("config/car/manufacturer")
public class WSConfigCarMunufacturer {

    @Inject
    CarManufacturer carManufacturer;
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response createCar() {
        Car car = carManufacturer.manufacturer(new Specification());
        return Response.ok(car).build();
    }
}
