/**
 * @Class BookEventHandler
 * @author Hector
 * @Created on Jun 29, 2019, 11:04:03 AM
 */
package javaee.examples.cdi.events.async.executor;

import java.util.concurrent.TimeUnit;
import javax.enterprise.event.ObservesAsync;

public class BookEventHandler {

    public void notifyPublisherOnline(@ObservesAsync BookEvent event) {
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
}
