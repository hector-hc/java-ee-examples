/*
* Classname:    FailureToNullInterceptor.java
* Author:       Héctor Hernández Chávez
* Date:         16-jul-2019
*/
package javaee.examples.jaxrs.bean.validation.client;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 * @author Héctor Hernández Chávez
 */
@Interceptor
public class FailureToNullInterceptor {
    
    @AroundInvoke
    public Object aroundInvoke(InvocationContext context) {
        System.out.println("FailureToNullInterceptor.aroundInvoke");
        try {
            return context.proceed();
        } catch (Exception e) {
            System.err.println("FailureToNullInterceptor exception " + e);
            return null;
        }
    }
}
