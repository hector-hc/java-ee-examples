
/**
 * @Class UserSenderJMS
 * @author Hector
 * @Created on Jun 30, 2019, 8:55:40 AM
 */

package javaee.examples.jms.senders;

import javaee.examples.jms.model.User;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSContext;

public class UserSenderJMS {

    @Inject
    private JMSContext jmsContext;
    
    @Resource(lookup = "jms.javaee.user")
    private Destination queue;
    
    public void send(User user) {
        jmsContext.createProducer().setDeliveryMode(DeliveryMode.PERSISTENT)
                .setDisableMessageID(true).setDisableMessageTimestamp(true).send(queue, user);
    }
}
