
/**
 * @Class ConnectionJMSProducer
 * @author Hector
 * @Created on Jun 23, 2019, 7:53:28 PM
 */

package javaee.examples.jms.producers;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;

@RequestScoped
public class ConnectionJMSProducer {

    @Inject
    ConnectionFactory connectionFactory;
    
    @Produces
    public Connection createConnectionJMS() {
        Connection conn = null;
        try {
            conn = connectionFactory.createConnection();
        } catch (JMSException jmse) {
            System.err.println("Exception at create Connection JMS " + jmse.getMessage());
        }
        return conn;
    }
    
    private void closeConnectionJMS(@Disposes Connection connection) throws JMSException {
        connection.close();
    }
}
