/**
 * @Class ExpensiveOrderMDB
 * @author Hector
 * @Created on Jun 23, 2019, 7:41:05 PM
 */
package javaee.examples.jms.mdbs;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(name = "ExpensiveOrderMDB", activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms.javaee.order")
    ,
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
    ,
    @ActivationConfigProperty(propertyName = "destination", propertyValue = "jms.javaee.order")
    ,
    @ActivationConfigProperty(propertyName = "resourceAdapter", propertyValue = "activemq-rar-54798925933191191288.15.9")
})
public class ExpensiveOrderMDB implements MessageListener {

    @Override
    public void onMessage(Message message) {
        try {
            if (message instanceof TextMessage) {
                TextMessage textMessage = (TextMessage) message;
                System.out.println("Order JMS: " + textMessage.getText());
            }
        } catch (JMSException jmse) {
            System.err.println("Exception at ExpensiveOrderMDB " + jmse.getMessage());
        }
    }

}
