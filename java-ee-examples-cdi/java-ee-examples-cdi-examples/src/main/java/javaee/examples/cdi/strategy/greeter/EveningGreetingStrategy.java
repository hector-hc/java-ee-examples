/*
* Classname:    EveningGreetingStrategy.java
* Author:       Héctor Hernández Chávez
* Date:         16-jul-2019
*/
package javaee.examples.cdi.strategy.greeter;

import java.time.LocalTime;

/**
 * @author Héctor Hernández Chávez
 */
public class EveningGreetingStrategy implements GreetingStrategy {

    @Override
    public boolean isAppropriate(LocalTime locaTime) {
        LocalTime limitNoon = LocalTime.of(18, 0, 0);
        LocalTime midnight = LocalTime.of(0, 0, 0);
        return locaTime.isAfter(limitNoon) && locaTime.isBefore(midnight);
    }

    @Override
    public String greet(String name) {
        return "Good evening, " + name;
    }

}
