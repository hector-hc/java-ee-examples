
/**
 * @Class AsyncClient
 * @author Hector
 * @Created on Jun 29, 2019, 9:22:35 PM
 */

package javaee.examples.websockets.async.client;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.websocket.ClientEndpoint;
import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;
import javax.ws.rs.container.AsyncResponse;

@ClientEndpoint
public class AsyncClient {

    private final String asyncServer = "ws://localhost:8080/java-ee-examples-websockets-examples-1.0/async-server";
    
    private static CountDownLatch messageLatch = new CountDownLatch(1);
    
    private Session session;
    
    private final AsyncResponse response;
    
    public AsyncClient(AsyncResponse response) {
        this.response = response;
    }
    
    @OnOpen
    public void onOpen(Session session) {
        System.out.println("AsyncClient::onOpen");
        this.session = session;
    }
    
    @OnMessage
    public void onMessage(String message) {
        System.out.println("AsyncClient::onMessage");
        response.resume(message);
        //messageLatch.countDown();
    }
    
    public void connect() {
        System.out.println("AsyncClient::connection_init");
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        try {
            ///container.setAsyncSendTimeout(5000);
            container.connectToServer(this, new URI(asyncServer));
            //messageLatch.await(10, TimeUnit.SECONDS);
        } catch (URISyntaxException | DeploymentException | IOException e) {
            System.err.println("" + e.getMessage());
        }
        System.out.println("AsyncClient::connection_end");
    }
    
    public void send(String message) {
        System.out.println("AsyncClient::send_message");
        this.session.getAsyncRemote().sendText(message);
        
    }
    
    public void close() {
        System.out.println("AsyncClient::close");
        try {
            this.session.close();
        } catch (IOException ioe) {
            System.err.println("" + ioe.getMessage());
        }
    }
}
