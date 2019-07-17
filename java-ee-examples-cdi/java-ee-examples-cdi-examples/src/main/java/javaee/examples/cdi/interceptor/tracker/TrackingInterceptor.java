/*
* Classname:    TrackingInterceptor.java
* Author:       Héctor Hernández Chávez
* Date:         17-jul-2019
*/
package javaee.examples.cdi.interceptor.tracker;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.util.function.Function;
import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 * @author Héctor Hernández Chávez
 */
@Tracked(Category.MANUFACTURER)
@Interceptor
@Priority(Interceptor.Priority.APPLICATION)
public class TrackingInterceptor {

    @Inject
    ProcessTracker processTracker;
    
    @AroundInvoke
    public Object aroundInvoke(InvocationContext context) throws Exception {
        Tracked tracked = resolveAnnotation(context);
        
        if (tracked != null) {
            Category category = tracked.value();
            processTracker.track(category);
        }
        return context.proceed();
    }
    
    private Tracked resolveAnnotation(InvocationContext context) {
        Function<AnnotatedElement, Tracked> extractor = c -> c.getAnnotation(Tracked.class);
        Method method = context.getMethod();
        
        Tracked tracked = extractor.apply(method);
        
        return tracked != null ? tracked : extractor.apply(method.getDeclaringClass());
    }
}
