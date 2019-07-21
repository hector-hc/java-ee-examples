
/**
 * @Class FancyGreetingInstance
 * @author Hector
 * @Created on Jul 21, 2019, 1:45:09 PM
 */

package javaee.examples.cdi.instance;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class FancyGreetingInstance implements GreetingInstance {

    @Override
    public String greet(String name) {
        return "Nice to meet you, hello " + name;
    }

}
