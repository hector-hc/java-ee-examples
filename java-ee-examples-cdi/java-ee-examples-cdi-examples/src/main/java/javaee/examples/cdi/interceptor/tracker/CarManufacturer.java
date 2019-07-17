/*
* Classname:    CarManufacturer.java
* Author:       Héctor Hernández Chávez
* Date:         17-jul-2019
*/
package javaee.examples.cdi.interceptor.tracker;

import javax.ejb.Stateless;

/**
 * @author Héctor Hernández Chávez
 */
@Stateless
public class CarManufacturer {

    @Tracked(Category.UNUSED)
    public Car manufactureCar(Specification spec) {
        System.out.println("CarManufacturer.manufactureCar");
        return new Car();
    }
}
