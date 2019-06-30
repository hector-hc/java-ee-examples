/**
 * @Class WSUserConsumer
 * @author Hector
 * @Created on Jun 30, 2019, 12:55:21 PM
 */
package javaee.examples.jaxrs.async.callback.ws;

import java.util.concurrent.TimeUnit;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.InvocationCallback;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Response;

@Path("async-callback")
public class WSUserConsumer {

    private Client client;
    private WebTarget target;

    @PostConstruct
    public void init() {
        client = ClientBuilder.newBuilder()
                .readTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .build();
        target = client.target("http://localhost:8080/java-ee-examples-jaxrs-examples-1.0/services/user-remote");
    }

    @PreDestroy
    public void destroy() {
        client.close();
    }

    @GET
    public void asyncService(@Suspended AsyncResponse response) {
        target.request().async().get(new InvocationCallback<Response>() {
            @Override
            public void completed(Response res) {
                response.resume(res);
            }

            @Override
            public void failed(Throwable t) {
                response.resume(Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(t.getMessage()).build());
            }
        });
    }
}
