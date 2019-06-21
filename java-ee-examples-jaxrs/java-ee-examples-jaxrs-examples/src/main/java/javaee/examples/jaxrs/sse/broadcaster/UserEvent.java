/*
* Classname:    UserEvent.java
* Author:       Héctor Hernández Chávez
* Date:         21-jun-2019
*/
package javaee.examples.jaxrs.sse.broadcaster;

import java.util.concurrent.TimeUnit;
import javax.ws.rs.sse.Sse;
import javax.ws.rs.sse.SseBroadcaster;

/**
 * @author Héctor Hernández Chávez
 */
public class UserEvent implements Runnable {

    private final Long id;
    private final SseBroadcaster sseBroadcaster;
    private final Sse sse;

    public UserEvent(Sse sse) {
        this.id = System.currentTimeMillis();
        this.sseBroadcaster = sse.newBroadcaster();
        this.sse = sse;
    }

    public Long getId() {
        return id;
    }

    public SseBroadcaster getSseBroadcaster() {
        return sseBroadcaster;
    }

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(5);
            sseBroadcaster.broadcast(sse.newEventBuilder().name("register")
                    .data(String.class, "Text from event " + id).build());
            sseBroadcaster.close();
        } catch (InterruptedException ie) {
            System.out.println("exception " + ie);
        }
    }
    
    
}
