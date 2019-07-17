/*
* Classname:    Car.java
* Author:       Héctor Hernández Chávez
* Date:         17-jul-2019
*/
package javaee.examples.cdi.decorator.configuration;

/**
 * @author Héctor Hernández Chávez
 */
public class Car {

    private final Specification specification;
    
    public Car(Specification specification) {
        this.specification = specification;
    }

    public Specification getSpecification() {
        return specification;
    }
    
    
}
