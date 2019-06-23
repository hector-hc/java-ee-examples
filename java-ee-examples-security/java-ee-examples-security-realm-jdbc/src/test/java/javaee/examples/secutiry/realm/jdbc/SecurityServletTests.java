
/**
 * @Class SecurityServletTests
 * @author Hector
 * @Created on Jun 23, 2019, 7:54:58 AM
 */

package javaee.examples.secutiry.realm.jdbc;

import java.net.URI;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class SecurityServletTests {
    
    private static final URI URI = UriBuilder.fromUri("http://localhost:8080/java-ee-examples-security-realm-jdbc-1.0").port(8080).build();
    
    private static Client client;
    
    @BeforeClass
    public static void init() {
        client = ClientBuilder.newClient().register(new Authenticator("customer01", "customer01"));
    }
    
    @AfterClass
    public static void destroy() {
        client.close();
    }
    
    @Test
    public void shouldDoRequest() {
        Response response =  client.target(URI).path("/security/SecutityServlet").request().buildGet().invoke();
        String message = response.readEntity(String.class);
        System.out.println("message: " + message);
        Assert.assertEquals(200, response.getStatus());
    }
}
