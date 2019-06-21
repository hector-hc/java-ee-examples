/*
* Classname:    SseBean.java
* Author:       Héctor Hernández Chávez
* Date:         21-jun-2019
 */
package javaee.examples.jaxrs.sse.broadcaster;

import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import javax.ws.rs.sse.SseEventSource;

/**
 * @author Héctor Hernández Chávez
 */
@RequestScoped
@Named
public class SseBean implements Serializable {

    @NotNull
    @Positive
    private Integer countClient;

    private Client client;

    @PostConstruct
    public void init() {
        client = ClientBuilder.newClient();
    }

    @PreDestroy
    public void destroy() {
        client.close();
    }

    public void sendEvent() throws URISyntaxException, InterruptedException {
        WebTarget target = client.target(URI.create("http://localhost:8080/java-ee-examples-jaxrs-examples-1.0/"));
        Response response = target.path("services/serversentservice/start").request()
                .post(Entity.json(""), Response.class);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sse Endpoint " + response.getLocation()));

        final Map<Integer, String> messageMap = new ConcurrentHashMap<>(countClient);

        final SseEventSource[] sources = new SseEventSource[countClient];

        final String processUriString = target.getUri().relativize(response.getLocation()).toString();
        final WebTarget sseTarget = target.path(processUriString);

        for (int i = 0; i < countClient; i++) {
            final int id = i;
            sources[id] = SseEventSource.target(sseTarget).build();
            sources[id].register((event) -> {
                final String message = event.readData(String.class);
                if (message.contains("Text")) {
                    messageMap.put(id, message);
                }
            });
            sources[i].open();
        }
        TimeUnit.SECONDS.sleep(10);

        for (SseEventSource source : sources) {
            source.close();
        }
        for (int i = 0; i < countClient; i++) {
            final String message = messageMap.get(i);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Message sent to client " + (i + 1) + ": " + message));
        }
    }

    public Integer getCountClient() {
        return countClient;
    }

    public void setCountClient(Integer countClient) {
        this.countClient = countClient;
    }
}
