/*
* Classname:    WSCompletionStageUserTests.java
* Author:       Héctor Hernández Chávez
* Date:         17-jul-2019
*/
package javaee.examples.jaxrs.async.completionstage;

import java.util.concurrent.CompletionStage;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Héctor Hernández Chávez
 */
public class WSCompletionStageUserTests {

    private static Client client;
    
    private static WebTarget target;
    
    @BeforeClass
    public static void setUpClass() {
        client = ClientBuilder.newBuilder().readTimeout(12, TimeUnit.SECONDS).connectTimeout(10, TimeUnit.SECONDS).build();
        target = client.target("http://localhost:8080/java-ee-examples-jaxrs-examples-1.0/services/completion-stage/user");
    }
    
    @AfterClass
    public static void destroy() {
        client.close();
    }
    
    @Test
    public void shouldGetCompletionStage() throws InterruptedException {
        System.out.println("method.init");
        User user = new User("hector", "hector.hdez@gmail.com");
        CountDownLatch waitLatch = new CountDownLatch(1);
        CompletionStage<Response> cs = target.request(MediaType.APPLICATION_JSON).rx().post(Entity.json(user));
        cs/*.thenApply(this::readResponse)*/.thenAccept(r -> {
            System.out.println("resultFuture: " + r);
            waitLatch.countDown();
        }).exceptionally(t -> {
            System.out.println("exception " + t.getMessage());
            waitLatch.countDown();
            return null;
        });
        System.out.println("method.finish");
        waitLatch.await();
    }
    
    private User readResponse(Response response) {
        System.out.println("response: " + response);
        return response.readEntity(User.class);
    }
}
