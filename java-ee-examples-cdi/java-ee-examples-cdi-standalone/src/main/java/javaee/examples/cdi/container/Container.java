/*
* Classname:    Container.java
* Author:       Héctor Hernández Chávez
* Date:         29-jul-2019
*/
package javaee.examples.cdi.container;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author Héctor Hernández Chávez
 */
public class Container {

    private final Map<Class<?>, Class<?>> instances = new HashMap<>();
    
    public <A, I extends A> Container register(final Class<A> api, final Class<I> implementation) {
        instances.put(api, implementation);
        return this;
    }
    
    public <T> T get(final Class<T> api) {
        try {
            /* api.cast(Optional.ofNullable(instances.get(api))
                    .orElseThrow(() -> new IllegalArgumentException("No bean for api <" + api.getName() + ">"))
                    .getConstructor().newInstance());*/
            final Object serviceInstance = Optional.ofNullable(instances.get(api))
                    .orElseThrow(() -> new IllegalArgumentException("No bean for api <" + api.getName() + ">"))
                    .getConstructor().newInstance();
            return api.cast(Proxy.newProxyInstance(api.getClassLoader(), new Class<?>[] {api}, 
                    new LogginHandler(serviceInstance, api)));
        } catch (final Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
}
