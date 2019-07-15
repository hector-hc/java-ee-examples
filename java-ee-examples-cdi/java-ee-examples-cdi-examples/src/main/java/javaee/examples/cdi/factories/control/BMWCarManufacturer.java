
/**
 * @Class BMWCarManufacturer
 * @author Hector
 * @Created on Jul 14, 2019, 8:26:40 PM
 */

package javaee.examples.cdi.factories.control;

import javaee.examples.cdi.factories.entity.BMW;
import javaee.examples.cdi.factories.entity.BMWCar;
import javaee.examples.cdi.factories.entity.GermanCar;

@BMW
public class BMWCarManufacturer implements GermanCarManufacturer {
    
    @Override
    public GermanCar manufactureCar() {
        return new BMWCar();
    }

}
