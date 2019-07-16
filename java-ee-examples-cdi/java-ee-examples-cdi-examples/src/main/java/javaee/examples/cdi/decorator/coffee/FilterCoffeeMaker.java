/*
* Classname:    FilterCoffeeMaker.java
* Author:       Héctor Hernández Chávez
* Date:         16-jul-2019
*/
package javaee.examples.cdi.decorator.coffee;

/**
 * @author Héctor Hernández Chávez
 */
public class FilterCoffeeMaker implements CoffeeMaker {

    @Override
    public void makeCoffee() {
        System.out.println("FilterCoffeeMaker.makeCoffee");
    }

}
