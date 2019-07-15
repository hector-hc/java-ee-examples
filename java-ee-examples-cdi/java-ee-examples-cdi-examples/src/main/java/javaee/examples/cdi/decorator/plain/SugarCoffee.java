/*
* Classname:    SugarCoffee.java
* Author:       Héctor Hernández Chávez
* Date:         15-jul-2019
*/
package javaee.examples.cdi.decorator.plain;

/**
 * @author Héctor Hernández Chávez
 */
public class SugarCoffee extends CoffeeGarnish {

    public SugarCoffee(Coffee coffee) {
        super(coffee);
    }
    
    @Override
    public double getCalories() {
        return super.getCalories() + 30.0;
    }
}
