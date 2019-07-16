/*
* Classname:    UserClient.java
* Author:       Héctor Hernández Chávez
* Date:         16-jul-2019
*/
package javaee.examples.jaxrs.bean.validation.client;

import java.util.concurrent.TimeUnit;
import javaee.examples.jaxrs.bean.validation.User;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.ApplicationException;
import javax.interceptor.Interceptors;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

/**
 * @author Héctor Hernández Chávez
 */
@ApplicationException
public class UserClient {
    private Client client;
    private WebTarget target;
    
    @PostConstruct
    private void initClient() {
        client = ClientBuilder.newBuilder().connectTimeout(100, TimeUnit.MILLISECONDS).readTimeout(2, TimeUnit.SECONDS).build();
        target = client.target("http://localhost:8080/java-ee-examples-jaxrs-examples-1.0/services/user/bean-validation/{userId}");
    }
    
    @Interceptors(FailureToNullInterceptor.class)
    public User getUserById(long id) {
        return target.resolveTemplate("userId", id).request().buildGet().invoke().readEntity(User.class);
    }
    
    @PreDestroy
    private void close() {
        client.close();
    }
}
