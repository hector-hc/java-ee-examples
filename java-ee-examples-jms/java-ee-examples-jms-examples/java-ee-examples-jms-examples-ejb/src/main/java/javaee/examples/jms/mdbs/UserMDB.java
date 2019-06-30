
/**
 * @Class UserMDB
 * @author Hector
 * @Created on Jun 30, 2019, 8:48:17 AM
 */

package javaee.examples.jms.mdbs;

import javaee.examples.jms.model.User;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms.javaee.user"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class UserMDB implements MessageListener {

    @Override
    public void onMessage(Message message) {
        System.out.println("message received..... ");
        try {
            //if (message instanceof User) {
                User user = message.getBody(User.class);
                System.out.println("User: " + user);
            //}
        } catch (JMSException jmse) {
            System.out.println("" + jmse.getMessage());
        }
    }

}
