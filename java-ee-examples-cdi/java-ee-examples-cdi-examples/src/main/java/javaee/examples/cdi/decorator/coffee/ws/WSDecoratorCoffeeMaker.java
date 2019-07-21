/*
* Classname:    WSCoffeeMakerDecorator.java
* Author:       Héctor Hernández Chávez
* Date:         16-jul-2019
*/
package javaee.examples.cdi.decorator.coffee.ws;

import javaee.examples.cdi.decorator.coffee.CoffeeMaker;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Héctor Hernández Chávez
 */
@Path("decorator/coffee-maker")
public class WSDecoratorCoffeeMaker {

    @Inject
    CoffeeMaker coffeeMaker;
    
    @GET
    @Produces({MediaType.TEXT_PLAIN})
    public Response makeCoffeee() {
        coffeeMaker.makeCoffee();
        return Response.ok("OK").build();
    }
}
