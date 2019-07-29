/*
* Classname:    Cache.java
* Author:       Héctor Hernández Chávez
* Date:         29-jul-2019
*/
package javaee.examples.cdi.interceptor.logger;

import java.lang.reflect.Method;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;
import javax.interceptor.InvocationContext;

/**
 * @author Héctor Hernández Chávez
 */
@ApplicationScoped
public class Cache {

    @Inject
    private BeanManager beanManager;
    
    private final ConcurrentMap<Method, String> loggerNamePerMethod = new ConcurrentHashMap<>();
    
    public String getLoggerName(final InvocationContext context) {
        return loggerNamePerMethod.computeIfAbsent(context.getMethod(), m -> Optional.ofNullable(m.getAnnotation(Log.class))
                .orElseGet(() -> context.getTarget().getClass().getAnnotation(Log.class)).value());
    }
}
