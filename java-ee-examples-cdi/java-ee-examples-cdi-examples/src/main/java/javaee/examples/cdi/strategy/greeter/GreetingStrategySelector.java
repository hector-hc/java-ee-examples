/*
* Classname:    GreetingStrategySelector.java
* Author:       Héctor Hernández Chávez
* Date:         16-jul-2019
*/
package javaee.examples.cdi.strategy.greeter;

import java.time.LocalTime;
import java.util.function.Function;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

/**
 * @author Héctor Hernández Chávez
 */
public class GreetingStrategySelector {

    @Inject
    @Any
    Instance<GreetingStrategy> strategies;
    
    @Produces
    public Function<String, String> exposStretegy() {
        for (GreetingStrategy strategy : strategies) {
            if (strategy.isAppropriate(LocalTime.now())) {
                return strategy::greet;
            }
        }
        throw new IllegalStateException("Couldn't find an appropriate greeting");
    }
}
