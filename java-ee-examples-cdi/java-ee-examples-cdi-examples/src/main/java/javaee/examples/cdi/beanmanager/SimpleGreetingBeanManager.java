
/**
 * @Class SimpleGreetingBeanManager
 * @author Hector
 * @Created on Jul 20, 2019, 9:00:00 PM
 */

package javaee.examples.cdi.beanmanager;

public class SimpleGreetingBeanManager implements GreetingBeanManager {

    @Override
    public String greet(String name) {
        return "Hello " + name;
    }

}
