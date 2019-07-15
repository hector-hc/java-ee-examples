
/**
 * @Class PorscheManufacturer
 * @author Hector
 * @Created on Jul 14, 2019, 8:27:55 PM
 */

package javaee.examples.cdi.factories.control;

import javaee.examples.cdi.factories.entity.GermanCar;
import javaee.examples.cdi.factories.entity.Porsche;
import javaee.examples.cdi.factories.entity.PorscheCar;

@Porsche
public class PorscheManufacturer implements GermanCarManufacturer {

    @Override
    public GermanCar manufactureCar() {
        return new PorscheCar();
    }

}
