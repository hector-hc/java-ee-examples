/**
 * @Class ClockServer
 * @author Hector
 * @Created on Jun 29, 2019, 12:49:50 PM
 */
package javaee.examples.websockets.simple;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedThreadFactory;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/clock")
public class ClockServer {

    @Resource
    ManagedThreadFactory factory;

//    private Thread updateThread;

    private boolean running = false;

    @OnOpen
    public void startClock(Session session) {
        System.out.println("startClock....");
        final Session mySession = session;
        final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("h:mm:ss a");
        this.running = true;
        System.out.println("factory: " + factory);
        Thread updateThread = factory.newThread(() -> {
            while (running) {
                String dateString = dtf.format(LocalDateTime.now());
                try {
                    mySession.getBasicRemote().sendText(dateString);
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException | IOException ie) {
                    running = false;
                }
            }
        });
//        this.updateThread = new Thread(() -> {
//            while (running) {
//                String dateString = dtf.format(LocalDateTime.now());
//                try {
//                    mySession.getBasicRemote().sendText(dateString);
//                    TimeUnit.SECONDS.sleep(1);
//                } catch (InterruptedException | IOException ie) {
//                    running = false;
//                }
//            }
//        });
        updateThread.setName("Thread_Websocket"); 
        updateThread.start();
    }

    @OnMessage
    public String handleMessage(String incomingMessage) {
        if ("stop".equals(incomingMessage)) {
            this.stopClock();
            return "clock stopped";
        } else {
            return "unkown message: " + incomingMessage;
        }
    }

    @OnError
    public void clockError(Throwable t) {
        this.stopClock();
    }

    @OnClose
    public void stopClock() {
        this.running = false;
        //this.updateThread = null;
    }
}
