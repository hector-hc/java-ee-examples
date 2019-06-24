
/**
 * @Class ConnectionFactoryJMSProducer
 * @author Hector
 * @Created on Jun 23, 2019, 7:50:03 PM
 */

package javaee.examples.jms.producers;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.jms.ConnectionFactory;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@RequestScoped
public class ConnectionFactoryJMSProducer {

    @Produces
    public ConnectionFactory createConnectionFactoryJMS() {
        ConnectionFactory connectionFactory = null;
        Context jndiContext;
        try {
            jndiContext = new InitialContext();
            connectionFactory = (ConnectionFactory) jndiContext.lookup("jms.javaee.ConnectionFactory");
        } catch (NamingException ne) {
            System.err.println("Exception at create Connection Factory JMS " + ne.getMessage());
        }
        return connectionFactory;
    }
}
