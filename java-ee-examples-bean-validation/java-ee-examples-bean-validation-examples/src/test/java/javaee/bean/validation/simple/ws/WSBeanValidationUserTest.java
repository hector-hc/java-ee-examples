
/**
 * @Class UserWSTest
 * @author Hector
 * @Created on Jun 14, 2019, 9:41:20 AM
 */

package javaee.bean.validation.simple.ws;

import java.util.Arrays;
import javaee.examples.bean.validation.simple.User;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WSBeanValidationUserTest {
    
    //mvn -Dtest=javaee.bean.validation.simple.ws.WSBeanValidationUserTest surefire:test
    
    private static final Logger LOGGER = LoggerFactory.getLogger(WSBeanValidationUserTest.class);

    private static Client client;
    
    private static WebTarget target;
    
    private static Jsonb jsonb;
    
    @BeforeClass
    public static void setUpClass() {
        client = ClientBuilder.newClient();
        target = client.target("http://localhost:8080/java-ee-examples-bean-validation-examples-1.0/services/beanvalidation/simple");
        JsonbConfig config = new JsonbConfig().withFormatting(Boolean.TRUE);
        jsonb = JsonbBuilder.create(config);
    }
    
    @AfterClass
    public static void destroy() {
        client.close();
    }
    
    @Test
    public void validUser() {
        User user = new User("hector", "hector.hernandez@gmail.com", Arrays.asList(1, 2));
        LOGGER.info(">>");
        LOGGER.info(jsonb.toJson(user));
        LOGGER.info("<<");
        Invocation invocation = target.request().buildPost(Entity.entity(user, 
                MediaType.APPLICATION_JSON));
        Response response = invocation.invoke();
        Assert.assertEquals(202, response.getStatus());
    }
    
    @Test
    public void invalidName() {
        User user = new User("", "hector.hernandez@gmail.com", Arrays.asList(1, 2));
        Invocation invocation = target.request().buildPost(Entity.entity(user, 
                MediaType.APPLICATION_JSON));
        Response response = invocation.invoke();
        Assert.assertEquals(400, response.getStatus());
    }
}
