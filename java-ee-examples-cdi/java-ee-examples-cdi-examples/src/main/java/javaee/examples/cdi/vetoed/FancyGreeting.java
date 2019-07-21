
/**
 * @Class FancyGreeting
 * @author Hector
 * @Created on Jul 21, 2019, 2:37:38 PM
 */

package javaee.examples.cdi.vetoed;

public class FancyGreeting implements Greeting {

    @Override
    public String greet(String name) {
        return "Hello " + name + " :)";
    }

}
