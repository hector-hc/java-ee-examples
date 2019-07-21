
/**
 * @Class SimpleGreeting
 * @author Hector
 * @Created on Jul 21, 2019, 2:36:55 PM
 */

package javaee.examples.cdi.vetoed;

import javax.enterprise.inject.Vetoed;

@Vetoed
public class SimpleGreeting implements Greeting {

    @Override
    public String greet(String name) {
        return "Hello " + name;
    }

}
