
/**
 * @Class AsyncServer
 * @author Hector
 * @Created on Jun 29, 2019, 9:13:54 PM
 */

package javaee.examples.websockets.async;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.inject.Singleton;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

//@Singleton
@javax.ejb.Singleton
@ServerEndpoint(value = "/async-server")
public class AsyncServer {

    private final List<Session> peers = Collections.synchronizedList(new ArrayList<>());
    
    @OnOpen
    public void onOpen(Session peer) {
        System.out.println("AsyncServer::onOpen");
        peers.add(peer);
    }
    
    @OnClose
    public void onClose(Session peer) {
        System.out.println("AsyncServer::onClose");
        peers.remove(peer);
    }
    
    @OnError
    public void onError(Throwable t) {
        System.out.println("AsyncServer::onError");
        System.err.println("" + t.getMessage());
    }
    
    @OnMessage
    public void onMessage(String message, Session peer) {
        System.out.println("AsyncServer::onMessage::size" + peers.size());
        peers.stream().filter(Session::isOpen).forEachOrdered(p -> {
            System.out.println("AsyncServer::onMessage::send:::init >>>>>");
            p.getAsyncRemote().sendText(message + " - Total peers: " + peers.size());
            System.out.println("AsyncServer::onMessage::send:::end <<<<<");
        });
    }
}
