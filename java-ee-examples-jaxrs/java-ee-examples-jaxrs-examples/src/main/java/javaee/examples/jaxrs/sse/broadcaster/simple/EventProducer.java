/*
* Classname:    EventProducer.java
* Author:       Héctor Hernández Chávez
* Date:         16-jul-2019
*/
package javaee.examples.jaxrs.sse.broadcaster.simple;

import java.time.Instant;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.event.Event;
import javax.inject.Inject;

/**
 * @author Héctor Hernández Chávez
 */
@Singleton
@Startup
public class EventProducer {

    @Inject
    Event<DomainEvent> domainEvent;
    
    @Schedule(second = "*/10", minute = "*", hour = "*")
    public void produceEvent() {
        System.out.println("EventProducer...");
        domainEvent.fire(new DomainEvent("Hello " + Instant.now()));
    }
}
