/*
* Classname:    ReportFutureBuilderTests.java
* Author:       Héctor Hernández Chávez
* Date:         17-jul-2019
*/
package javaee.examples.ejb.async.future;

import java.util.concurrent.CompletionStage;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Héctor Hernández Chávez
 */
public class ReportFutureBuilderTests {

    private static Client client;
    
    private static WebTarget target;
    
    @BeforeClass
    public static void setUpClass() {
        client = ClientBuilder.newBuilder().readTimeout(12, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS).build();
        target = client.target("http://localhost:8080/java-ee-examples-ejb-examples-web/services/ejb/sync/report/future");
    }
    
    @AfterClass
    public static void destroy() {
        client.close();
    }
    
    @Test
    public void shouldGetResultFuture() throws InterruptedException {
        System.out.println("method.init");
        CountDownLatch waitLantch = new CountDownLatch(1);
        CompletionStage<Response> cs = target.request(MediaType.TEXT_PLAIN).rx().get();
        
        cs.thenApply(this::readResponse).thenAccept(r -> {
            System.out.println("resultFuture: " + r);
            waitLantch.countDown();
        }).exceptionally(e -> {
            System.out.println("exception " + e.getMessage());
            waitLantch.countDown();
            return null;
        });
        System.out.println("method.finish");
        waitLantch.await();
    }
    
    private String readResponse(Response response) {
        System.out.println("readResponse...");
        return response.readEntity(String.class);
    }
            
}
