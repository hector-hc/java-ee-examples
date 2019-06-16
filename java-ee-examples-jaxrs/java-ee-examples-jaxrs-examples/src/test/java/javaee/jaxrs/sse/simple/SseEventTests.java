
/**
 * @Class SseEventTests
 * @author Hector
 * @Created on Jun 15, 2019, 2:28:42 PM
 */

package javaee.jaxrs.sse.simple;

import java.util.concurrent.TimeUnit;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.sse.SseEventSource;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class SseEventTests {

    public static Client client;
    
    public static WebTarget webTarget;
    
    @BeforeClass
    public static void init() {
        client = ClientBuilder.newClient();
        webTarget = client.target("http://localhost:8080/ssevents");
    }
    
    @AfterClass
    public static void destroy() {
        client.close();
    }
    
    @Test
    public void shouldReceiveSseEvents() throws InterruptedException {
        try (SseEventSource sseSource = SseEventSource.target(webTarget).build()) {
            sseSource.register(System.out::println);
            sseSource.open();
            for (int counter = 0; counter < 5; counter++) {
                System.out.println(" ");
                for (int innerCounter = 0; innerCounter < 5; innerCounter++) {
                    webTarget.request().post(Entity.json("event " + innerCounter));
                }
                TimeUnit.SECONDS.sleep(1);
            }
        }
        System.out.println("\nAll messages Consumed...");
    }
}
