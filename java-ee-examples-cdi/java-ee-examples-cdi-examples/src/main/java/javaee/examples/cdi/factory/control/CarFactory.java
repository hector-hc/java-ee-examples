
/**
 * @Class CarFactory
 * @author Hector
 * @Created on Jul 14, 2019, 7:37:05 PM
 */

package javaee.examples.cdi.factory.control;

import javaee.examples.cdi.factory.entity.Car;
import javaee.examples.cdi.factory.entity.Specification;

public class CarFactory {

    public Car createCar(Specification spec) {
        return new Car(spec);
    }
}
