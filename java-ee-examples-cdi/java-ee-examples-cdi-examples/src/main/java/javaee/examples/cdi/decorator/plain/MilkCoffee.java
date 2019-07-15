/*
* Classname:    MilkCoffee.java
* Author:       Héctor Hernández Chávez
* Date:         15-jul-2019
*/
package javaee.examples.cdi.decorator.plain;

/**
 * @author Héctor Hernández Chávez
 */
public class MilkCoffee extends CoffeeGarnish {

    public MilkCoffee(Coffee coffee) {
        super(coffee);
    }
    
    @Override
    public double getCalories() {
        return super.getCalories() + 20.0;
    }
}
