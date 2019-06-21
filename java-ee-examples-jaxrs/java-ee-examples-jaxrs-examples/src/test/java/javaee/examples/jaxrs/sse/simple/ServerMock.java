
/**
 * @Class ServerMock
 * @author Hector
 * @Created on Jun 15, 2019, 2:21:11 PM
 */

package javaee.examples.jaxrs.sse.simple;

import javaee.examples.jaxrs.sse.simple.SseResourceMessage;
import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class ServerMock {
    public static final String BASE_PATH = "ssevents";
    
    public static final URI CONTEXT = URI.create("http://localhost:8080/");
    
    public static void main(String[] args) {
        try {
            final ResourceConfig resourceConfig = new ResourceConfig(SseResourceMessage.class);
            final HttpServer server = GrizzlyHttpServerFactory.createHttpServer(CONTEXT, resourceConfig, false);
            server.start();
            System.out.println(String.format("Mock Server started at %s%s", CONTEXT, BASE_PATH));
            Thread.currentThread().join();
        } catch (IOException | InterruptedException e) {
            System.err.println("" + e.getMessage());
        }
    }
}
