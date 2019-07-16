/*
* Classname:    MorningGreetingStrategy.java
* Author:       Héctor Hernández Chávez
* Date:         16-jul-2019
*/
package javaee.examples.cdi.strategy.greeter;

import java.time.LocalTime;

/**
 * @author Héctor Hernández Chávez
 */
public class MorningGreetingStrategy implements GreetingStrategy {

    @Override
    public boolean isAppropriate(LocalTime locaTime) {
        LocalTime noon = LocalTime.of(12, 0, 0);
        LocalTime midnight = LocalTime.of(0, 0, 0);
        return locaTime.isAfter(midnight) && locaTime.isBefore(noon);
    }

    @Override
    public String greet(String name) {
        return "Good morning, " + name;
    }

}
