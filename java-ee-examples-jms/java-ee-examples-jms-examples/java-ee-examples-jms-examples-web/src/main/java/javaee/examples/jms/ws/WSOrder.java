
/**
 * @Class WSOrder
 * @author Hector
 * @Created on Jun 23, 2019, 7:59:01 PM
 */

package javaee.examples.jms.ws;

import java.util.Random;
import java.util.UUID;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

@Path("order")
public class WSOrder {

    @Inject
    Connection connection;
    
    @Resource(lookup = "jms/__defaultConnectionFactory")
    ConnectionFactory connectionFactory;
    
    @Resource(lookup = "jms.new.order")
    private Queue queue;
    
    @GET
    @Path("classic-api")
    public Response sendOrderClassicApiJMS() {
        try {
            Context jndiContext = new InitialContext();
            Destination queue = (Destination) jndiContext.lookup("jms.javaee.order");
            try (Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE)) {
                try (MessageProducer producer = session.createProducer(queue)) {
                    TextMessage message = session.createTextMessage("order_id: " + UUID.randomUUID().toString());
                    producer.send(message);
                }
                return Response.ok("OK").build();
            }
        } catch (NamingException | JMSException e) {
            throw new WebApplicationException();
        }
    }
    
    @GET
    @Path("new-api")
    public Response sendOrderNewApiJMS() {
        System.out.println("connectionFactory: " + connectionFactory);
        System.out.println("queue: " + queue);
        try (JMSContext context = connectionFactory.createContext()) {
            context.createProducer().send(queue, "order_id: " + UUID.randomUUID().toString());
        }
        return Response.ok("OK").build();
    }
}
