/**
 * @Class BookEventHandler
 * @author Hector
 * @Created on Jun 29, 2019, 12:19:01 PM
 */
package javaee.examples.cdi.events.async.qualifiers;

import java.util.concurrent.TimeUnit;
import javax.enterprise.event.ObservesAsync;

public class BookEventHandler {

    public void notifyPublisherOnline(@ObservesAsync @OnlineSale BookEvent event) {
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

    public void notifyPublisherInStore(@ObservesAsync @StoreSale BookEvent event) {
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
