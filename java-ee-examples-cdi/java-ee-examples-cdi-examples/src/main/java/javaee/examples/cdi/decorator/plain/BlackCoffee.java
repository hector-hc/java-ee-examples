/*
* Classname:    BlackCoffee.java
* Author:       Héctor Hernández Chávez
* Date:         15-jul-2019
*/
package javaee.examples.cdi.decorator.plain;

/**
 * @author Héctor Hernández Chávez
 */
public class BlackCoffee implements Coffee {

    @Override
    public double getCaffeine() {
        return 100;
    }

    @Override
    public double getCalories() {
        return 0;
    }

}
