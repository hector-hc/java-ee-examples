/*
* Classname:    CreamCoffee.java
* Author:       Héctor Hernández Chávez
* Date:         15-jul-2019
*/
package javaee.examples.cdi.decorator.plain;

/**
 * @author Héctor Hernández Chávez
 */
public class CreamCoffee extends CoffeeGarnish {

    public CreamCoffee(Coffee coffee) {
        super(coffee);
    }
    
    @Override
    public double getCalories() {
        return super.getCalories() + 100.0;
    }
}
