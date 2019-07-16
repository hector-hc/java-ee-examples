/*
* Classname:    Greeter.java
* Author:       Héctor Hernández Chávez
* Date:         16-jul-2019
*/
package javaee.examples.cdi.strategy.plain;

import java.util.function.Function;

/**
 * @author Héctor Hernández Chávez
 */
public class Greeter {

    private Function<String, String> strategy;
    
    public String greet(String name) {
        return strategy.apply(name) + ", my name is Duke";
    }

    public void setStrategy(Function<String, String> strategy) {
        this.strategy = strategy;
    }
    
}
