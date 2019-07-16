/*
* Classname:    CountingCoffeeMaker.java
* Author:       Héctor Hernández Chávez
* Date:         16-jul-2019
*/
package javaee.examples.cdi.decorator.coffee;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

/**
 * @author Héctor Hernández Chávez
 */
@Decorator
public class CountingCoffeeMaker implements CoffeeMaker {

    private static final int MAX_COFFEE = 3;
    
    private int count;
    
    @Inject
    @Delegate
    CoffeeMaker coffeeMaker;
    
    @Override
    public void makeCoffee() {
        System.out.println("CountingCoffeeMaker.count: " + count);
        if (count >= MAX_COFFEE) {
            throw new IllegalStateException("Reached maximum coffee limit");
        }
        count++;
        coffeeMaker.makeCoffee();
    }

}
