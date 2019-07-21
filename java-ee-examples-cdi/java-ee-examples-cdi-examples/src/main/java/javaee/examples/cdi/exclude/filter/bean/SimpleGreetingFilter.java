
/**
 * @Class SimpleGreetingFilter
 * @author Hector
 * @Created on Jul 21, 2019, 1:31:21 PM
 */

package javaee.examples.cdi.exclude.filter.bean;

import javaee.examples.cdi.exclude.filter.GreetingExcludeFilter;

public class SimpleGreetingFilter implements GreetingExcludeFilter {

    @Override
    public String greet(String name) {
        return "Hello";
    }

}
