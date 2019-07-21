
/**
 * @Class GreetingReceiverConditional
 * @author Hector
 * @Created on Jul 21, 2019, 1:16:37 PM
 */

package javaee.examples.cdi.events.conditional;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;

@SessionScoped
public class GreetingReceiverConditional implements EventReceiverConditional, Serializable {

    private String greet = "Willkomeen";
    
    public void receive(@Observes(notifyObserver = Reception.IF_EXISTS) String greet) {
        this.greet = greet;
    }
    
    @Override
    public String getGreet() {
        return this.greet;
    }

}
