/*
* Classname:    WSDecoratorPlain.java
* Author:       Héctor Hernández Chávez
* Date:         15-jul-2019
*/
package javaee.examples.cdi.decorator.plain.ws;

import javaee.examples.cdi.decorator.plain.BlackCoffee;
import javaee.examples.cdi.decorator.plain.Coffee;
import javaee.examples.cdi.decorator.plain.CreamCoffee;
import javaee.examples.cdi.decorator.plain.MilkCoffee;
import javaee.examples.cdi.decorator.plain.SugarCoffee;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Héctor Hernández Chávez
 */
@Path("decorator/plain")
public class WSDecoratorPlain {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response makeCoffe() {
        Coffee coffee = new SugarCoffee(new CreamCoffee(new MilkCoffee(new BlackCoffee())));
        return Response.ok("The calories are: " + coffee.getCalories()).build();
    }
}
