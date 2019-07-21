
/**
 * @Class SmileyGreetingBeanManager
 * @author Hector
 * @Created on Jul 20, 2019, 9:00:47 PM
 */

package javaee.examples.cdi.beanmanager;

public class SmileyGreetingBeanManager extends SimpleGreetingBeanManager {
    @Override
    public String greet(String name) {
        return super.greet(name + " :-)");
    }
}
