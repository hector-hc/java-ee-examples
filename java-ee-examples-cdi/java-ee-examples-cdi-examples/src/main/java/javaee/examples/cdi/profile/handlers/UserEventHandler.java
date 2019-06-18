
/**
 * @Class UserEventHandler
 * @author Hector
 * @Created on Jun 17, 2019, 9:49:41 PM
 */

package javaee.examples.cdi.profile.handlers;

import javaee.examples.cdi.profile.User;
import javax.enterprise.event.Observes;
import javax.enterprise.event.ObservesAsync;

public class UserEventHandler {

    public void sendUserNotification(@Observes User user) {
        System.out.println("sendUserNotification: " + user);
    }
    
    public void sendUserNotificationAsync(@ObservesAsync User user) {
        System.out.println("sendUserNotificationAsync: " + user);
    }
}
