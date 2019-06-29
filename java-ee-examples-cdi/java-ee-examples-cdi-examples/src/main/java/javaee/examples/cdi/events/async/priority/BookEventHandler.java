/**
 * @Class BookEventHandler
 * @author Hector
 * @Created on Jun 29, 2019, 12:01:57 PM
 */
package javaee.examples.cdi.events.async.priority;

import java.util.concurrent.TimeUnit;
import javax.annotation.Priority;
import javax.enterprise.event.ObservesAsync;
import javax.interceptor.Interceptor;

public class BookEventHandler {

    public void notifyPublisherOnline(@ObservesAsync @Priority(Interceptor.Priority.APPLICATION + 200) BookEvent event) {
        System.out.println("notifyPublisherOnline...");
        event.getNotifyList().stream().forEach(be -> {
            System.out.println("notification: " + be);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ie) {
                System.out.println("exception at notifyPublisherOnline " + ie);
            }
        });
    }
    
    public void notifyPublisherInStore(@ObservesAsync @Priority(Interceptor.Priority.APPLICATION + 100) BookEvent event) {
        System.out.println("notifyPublisherInStore...");
        event.getNotifyList().stream().forEach(be -> {
            System.out.println("notification: " + be);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ie) {
                System.out.println("exception at notifyPublisherInStore " + ie);
            }
        });
    }
}
