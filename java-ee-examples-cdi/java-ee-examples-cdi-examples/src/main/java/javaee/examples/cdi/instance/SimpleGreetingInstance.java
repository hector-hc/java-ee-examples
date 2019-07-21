
/**
 * @Class SimpleGreetingInstance
 * @author Hector
 * @Created on Jul 21, 2019, 1:44:23 PM
 */

package javaee.examples.cdi.instance;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class SimpleGreetingInstance implements GreetingInstance {

    @Override
    public String greet(String name) {
        return "Hello " + name;
    }

}
