
/**
 * @Class BMWCarManufacturerProducer
 * @author Hector
 * @Created on Jul 14, 2019, 8:28:56 PM
 */

package javaee.examples.cdi.factories.control;

import javaee.examples.cdi.factories.entity.BMW;
import javaee.examples.cdi.factories.entity.BMWCar;
import javaee.examples.cdi.factories.entity.GermanCar;
import javax.enterprise.inject.Produces;

public class BMWCarManufacturerProducer {

    @Produces
    @BMW
    public GermanCar manufactureCar() {
        return new BMWCar();
    }
}
