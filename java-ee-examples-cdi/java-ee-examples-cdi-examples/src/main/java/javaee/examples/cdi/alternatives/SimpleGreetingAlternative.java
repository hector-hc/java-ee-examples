
/**
 * @Class SimpleGreetingAlternative
 * @author Hector
 * @Created on Jul 20, 2019, 8:12:01 AM
 */

package javaee.examples.cdi.alternatives;

import javax.enterprise.inject.Alternative;

@Alternative
public class SimpleGreetingAlternative implements GreetingAlternative {

    @Override
    public String greet(String name) {
        return "Hello " + name;
    }

}
