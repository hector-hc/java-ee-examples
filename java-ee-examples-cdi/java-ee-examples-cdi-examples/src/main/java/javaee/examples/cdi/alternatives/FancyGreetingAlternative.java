
/**
 * @Class FancyGreetingAlternative
 * @author Hector
 * @Created on Jul 20, 2019, 8:13:04 AM
 */

package javaee.examples.cdi.alternatives;

import javax.enterprise.inject.Alternative;

@Alternative
public class FancyGreetingAlternative implements GreetingAlternative {

    @Override
    public String greet(String name) {
        return "Nice to meet you, hello " + name;
    }

}
