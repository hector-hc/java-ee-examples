/*
* Classname:    CoffeeGarnish.java
* Author:       Héctor Hernández Chávez
* Date:         15-jul-2019
*/
package javaee.examples.cdi.decorator.plain;

/**
 * @author Héctor Hernández Chávez
 */
public class CoffeeGarnish implements Coffee {

    private final Coffee coffee;
    
    public CoffeeGarnish(final Coffee coffee) {
        this.coffee = coffee;
    }
    
    @Override
    public double getCaffeine() {
        return coffee.getCaffeine();
    }
    
    @Override
    public double getCalories() {
        return coffee.getCalories();
    }
}
