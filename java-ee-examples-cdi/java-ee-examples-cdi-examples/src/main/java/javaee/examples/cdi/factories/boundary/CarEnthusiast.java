
/**
 * @Class CarEnthusiast
 * @author Hector
 * @Created on Jul 14, 2019, 8:31:27 PM
 */

package javaee.examples.cdi.factories.boundary;

import javaee.examples.cdi.factories.control.GermanCarManufacturer;
import javaee.examples.cdi.factories.entity.BMW;
import javaee.examples.cdi.factories.entity.GermanCar;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class CarEnthusiast {

    @Inject
    @BMW 
    GermanCarManufacturer carManufacturer;
    
    public GermanCar getBMWCar() {
        return carManufacturer.manufactureCar();
    }
}
