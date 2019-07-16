/*
* Classname:    GreetingStrategy.java
* Author:       Héctor Hernández Chávez
* Date:         16-jul-2019
* © Concepto Móvil S.A. de C.V. 2014
*/
package javaee.examples.cdi.strategy.greeter;

import java.time.LocalTime;

/**
 * @author Héctor Hernández Chávez
 */
public interface GreetingStrategy {
    
    boolean isAppropriate(LocalTime locaTime);
    
    String greet(String name);
}
