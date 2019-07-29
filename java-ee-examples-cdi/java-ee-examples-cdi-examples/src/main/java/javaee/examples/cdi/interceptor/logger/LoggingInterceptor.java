/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaee.examples.cdi.interceptor.logger;

import java.util.Optional;
import java.util.logging.Logger;
import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 *
 * @author Héctor Hernández Chávez
 */
@Log
@Interceptor
@Priority(Interceptor.Priority.APPLICATION)
public class LoggingInterceptor {
    
    @Inject
    Cache cache;
    
    @AroundInvoke
    public Object invoke(final InvocationContext context) throws Exception {
        //final Logger logger = Logger.getLogger(context.getTarget().getClass().getName());
        //final Logger logger = Logger.getLogger(getLoggerName(context));
        String loggerName = cache.getLoggerName(context);
        final Logger logger = Logger.getLogger(loggerName);
        logger.info(() -> "Calling with cache logger" + context.getMethod().getName());
        try {
            return context.proceed();
        } finally {
            logger.info(() -> "Called " +  context.getMethod().getName());
        }
    }
    
    private String getLoggerName(InvocationContext context) {
        return Optional.ofNullable(context.getMethod().getAnnotation(Log.class))
                .orElseGet(() -> context.getTarget().getClass().getAnnotation(Log.class)).value();
    }
}
