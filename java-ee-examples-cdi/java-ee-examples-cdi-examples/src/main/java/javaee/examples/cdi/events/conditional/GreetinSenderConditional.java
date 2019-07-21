
/**
 * @Class GreetinSenderConditional
 * @author Hector
 * @Created on Jul 21, 2019, 1:15:09 PM
 */

package javaee.examples.cdi.events.conditional;

import javax.enterprise.event.Event;
import javax.inject.Inject;

public class GreetinSenderConditional implements EventSenderConditional {

    @Inject
    Event<String> event;
    
    @Override
    public void sent(String message) {
        event.fire(message);
    }

}
