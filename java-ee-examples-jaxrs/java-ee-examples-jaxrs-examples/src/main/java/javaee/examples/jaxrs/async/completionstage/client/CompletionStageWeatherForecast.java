/*
* Classname:    CompletionStageWeatherForecast.java
* Author:       Héctor Hernández Chávez
* Date:         19-jul-2019
*/
package javaee.examples.jaxrs.async.completionstage.client;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 * @author Héctor Hernández Chávez
 */
@ApplicationScoped
public class CompletionStageWeatherForecast {
    private Client client;
    
    private List<WebTarget> targets;
    
    @Resource
    ManagedExecutorService mes;
    
    @PostConstruct
    private void initClient() {
        client = ClientBuilder.newClient();
        targets = Arrays.asList(client.target("http://localhost:8080/java-ee-examples-jaxrs-examples-1.0/services/async-completable-future/forecast01"), 
                client.target("http://localhost:8080/java-ee-examples-jaxrs-examples-1.0/services/async-completable-future/forecast02"));
    }
    
    @PreDestroy
    private void closeClient() {
        client.close();
    }
    
    public Forecast getAvegareForecast() {
        return invokeTargetAsync().stream().reduce((l, r) -> l.thenCombine(r, 
                this::calForecastAvegare))
                .map(s -> s.toCompletableFuture().join())
                .orElseThrow(() -> new IllegalStateException("No weather service available"));
    }
    
    private List<CompletionStage<Forecast>> invokeTargetAsync() {
        return targets.stream().map(t -> t.request(MediaType.APPLICATION_JSON)
                .rx().get(Forecast.class)).collect(Collectors.toList());
    }
    
    private Forecast calForecastAvegare(Forecast first, Forecast second) {
        return first;
    }
}
