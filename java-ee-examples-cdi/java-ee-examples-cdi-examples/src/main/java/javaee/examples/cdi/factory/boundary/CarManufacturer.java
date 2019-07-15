
/**
 * @Class CarManufacturer
 * @author Hector
 * @Created on Jul 14, 2019, 7:40:55 PM
 */

package javaee.examples.cdi.factory.boundary;

import javaee.examples.cdi.factory.control.CarFactory;
import javaee.examples.cdi.factory.control.CarStorage;
import javaee.examples.cdi.factory.entity.Car;
import javaee.examples.cdi.factory.entity.Specification;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class CarManufacturer {

    @Inject
    CarFactory carFactory;
    
    @Inject
    private CarStorage carStorage;
    
    public Car manufactureCar(Specification spec) {
        Car car = carFactory.createCar(spec);
        carStorage.store(car);
        return car;
    }
    
    public Car getCarById(Integer id) {
        return carStorage.retrieve(id);
    }
}
