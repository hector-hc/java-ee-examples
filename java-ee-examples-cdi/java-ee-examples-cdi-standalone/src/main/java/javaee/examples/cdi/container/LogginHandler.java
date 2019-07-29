/*
* Classname:    LogginHandler.java
* Author:       Héctor Hernández Chávez
* Date:         29-jul-2019
*/
package javaee.examples.cdi.container;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Logger;

/**
 * @author Héctor Hernández Chávez
 */
public class LogginHandler implements InvocationHandler {

    private final Object delegate;
    private final Logger logger;
    
    public LogginHandler(final Object delegate, final Class<?> api) {
        this.delegate = delegate;
        this.logger = Logger.getLogger(api.getName());
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        logger.info(() -> "Calling " + method.getName());
        try {
            return method.invoke(delegate, args);
        } catch (InvocationTargetException ite) {
            logger.info("error");
            return null;
        } finally {
            logger.info(() -> "Called " + method.getName());
        }
    }

}
