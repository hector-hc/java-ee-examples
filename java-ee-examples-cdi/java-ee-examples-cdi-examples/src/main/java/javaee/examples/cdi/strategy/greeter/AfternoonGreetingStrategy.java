/*
* Classname:    AfternoonGreetingStrategy.java
* Author:       Héctor Hernández Chávez
* Date:         16-jul-2019
*/
package javaee.examples.cdi.strategy.greeter;

import java.time.LocalTime;

/**
 * @author Héctor Hernández Chávez
 */
public class AfternoonGreetingStrategy implements GreetingStrategy {

    @Override
    public boolean isAppropriate(LocalTime locaTime) {
        LocalTime noon = LocalTime.of(12, 0, 0);
        LocalTime limitNoon = LocalTime.of(18, 0, 0);
        return locaTime.isAfter(noon) && locaTime.isBefore(limitNoon);
    }

    @Override
    public String greet(String name) {
        return "Good afternoon, " + name;
    }

}
