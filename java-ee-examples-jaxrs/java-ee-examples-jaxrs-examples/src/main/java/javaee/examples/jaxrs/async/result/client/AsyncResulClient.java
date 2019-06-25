/*
* Classname:    AsyncResulClient.java
* Author:       Héctor Hernández Chávez
* Date:         25-jun-2019
*/
package javaee.examples.jaxrs.async.result.client;

import java.util.concurrent.CompletionStage;
import java.util.concurrent.TimeUnit;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Héctor Hernández Chávez
 */
@Stateless
public class AsyncResulClient {

    private Client client;
    
    private WebTarget target;
    
    @PostConstruct
    public void inti() {
        client = ClientBuilder.newBuilder()
                .readTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .build();
        target = client.target("http://localhost:8080/java-ee-examples-jaxrs-examples-1.0/services/async-result");
    }
    
    @PreDestroy
    public void destroy() {
        client.close();
    }
    
    public CompletionStage<Response> getResult() {
        return target.request(MediaType.TEXT_PLAIN).rx().get();
    }
}
