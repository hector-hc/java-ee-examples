/*
* Classname:    CarManufacturer.java
* Author:       Héctor Hernández Chávez
* Date:         17-jul-2019
*/
package javaee.examples.cdi.decorator.configuration;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @author Héctor Hernández Chávez
 */
@Stateless
public class CarManufacturer {

    @Inject
    @Config(value = "car.default.color")
    String defaultColor;
    
    public Car manufacturer(Specification spec) {
        spec.setColor(defaultColor);
        return new Car(spec);
    }
}
