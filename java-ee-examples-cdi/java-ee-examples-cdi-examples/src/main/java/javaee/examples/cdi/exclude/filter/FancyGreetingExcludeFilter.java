
/**
 * @Class FancyGreetingExcludeFilter
 * @author Hector
 * @Created on Jul 21, 2019, 1:30:32 PM
 */

package javaee.examples.cdi.exclude.filter;

public class FancyGreetingExcludeFilter implements GreetingExcludeFilter {

    @Override
    public String greet(String name) {
        return "Hello " + name + " :)";
    }

}
