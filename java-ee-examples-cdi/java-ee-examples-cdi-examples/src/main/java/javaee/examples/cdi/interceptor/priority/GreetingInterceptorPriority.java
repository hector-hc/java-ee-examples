
/**
 * @interface GreetingInterceptorPriority
 * @Author Hector
 * @Created on Jul 21, 2019, 2:04:58 PM
 */

package javaee.examples.cdi.interceptor.priority;

public interface GreetingInterceptorPriority {
    String getGreet();
    void setGreet(String name);
}
