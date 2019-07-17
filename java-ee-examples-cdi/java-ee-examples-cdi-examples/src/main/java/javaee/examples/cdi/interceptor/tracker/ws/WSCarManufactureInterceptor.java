/*
* Classname:    WSCarManufactureInterceptor.java
* Author:       Héctor Hernández Chávez
* Date:         17-jul-2019
*/
package javaee.examples.cdi.interceptor.tracker.ws;

import javaee.examples.cdi.interceptor.tracker.Car;
import javaee.examples.cdi.interceptor.tracker.CarManufacturer;
import javaee.examples.cdi.interceptor.tracker.Specification;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * @author Héctor Hernández Chávez
 */
@Path("interceptor/car/manufacture")
public class WSCarManufactureInterceptor {

    @Inject
    CarManufacturer carManuracturer;
    
    @GET
    public Response createCar() {
        Car car = carManuracturer.manufactureCar(new Specification());
        return Response.ok(car.toString()).build();
    }
}
