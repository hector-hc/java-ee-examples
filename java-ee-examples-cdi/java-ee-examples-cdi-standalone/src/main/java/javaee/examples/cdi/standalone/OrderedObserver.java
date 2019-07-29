
/**
 * @Class OrderedObserver
 * @author Hector
 * @Created on Jun 14, 2019, 1:31:52 PM
 */

package javaee.examples.cdi.standalone;

import javax.annotation.Priority;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import javax.interceptor.Interceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderedObserver {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderedObserver.class);

    public static void main(String[] args) {
        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {
            container.getBeanManager().fireEvent(new MyEvent("event -> " + System.currentTimeMillis()));
        }
    }
    
   public void thisEventBefore(@Observes @Priority(Interceptor.Priority.APPLICATION - 200) MyEvent event){
        LOGGER.info("thisEventBefore: {} ", event.getValue());
    }
    
    public void thisEventAfter(@Observes @Priority(Interceptor.Priority.APPLICATION + 200) MyEvent event) {
        LOGGER.info("thisEventAfter: {}", event.getValue());
    }
}
