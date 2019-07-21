
/**
 * @Class LowPriorityInterceptor
 * @author Hector
 * @Created on Jul 21, 2019, 2:08:32 PM
 */

package javaee.examples.cdi.interceptor.priority;

import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@MyInterceptorBindingPriority
@Priority(Interceptor.Priority.APPLICATION + 200)
public class LowPriorityInterceptor {

    @AroundInvoke
    public Object log(InvocationContext context) throws Exception {
        Object[] parameters = context.getParameters();
        if (parameters.length > 0 && parameters[0] instanceof String) {
            String param = (String) parameters[0];
            parameters[0] = param + " Nice to meet you.";
            context.setParameters(parameters);
        }
        return context.proceed();
    }
}
