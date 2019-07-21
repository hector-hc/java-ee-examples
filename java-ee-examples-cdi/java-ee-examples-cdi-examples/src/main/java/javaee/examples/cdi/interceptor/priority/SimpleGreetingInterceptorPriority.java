
/**
 * @Class SimpleGreetingInterceptorPriority
 * @author Hector
 * @Created on Jul 21, 2019, 2:05:58 PM
 */

package javaee.examples.cdi.interceptor.priority;

@MyInterceptorBindingPriority
public class SimpleGreetingInterceptorPriority implements GreetingInterceptorPriority {

    private String greet;
    
    @Override
    public String getGreet() {
        return this.greet;
    }

    @Override
    public void setGreet(String name) {
        this.greet = name;
    }

}
