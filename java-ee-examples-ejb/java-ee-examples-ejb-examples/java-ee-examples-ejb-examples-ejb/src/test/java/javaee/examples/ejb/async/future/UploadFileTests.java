/*
* Classname:    UploadFileTests.java
* Author:       Héctor Hernández Chávez
* Date:         12-ago-2019
*/
package javaee.examples.ejb.async.future;

import java.io.File;
import java.io.FileInputStream;
import java.util.Objects;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.TimeUnit;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Héctor Hernández Chávez
 */
public class UploadFileTests {
    
    private static Client client;
    
    private static WebTarget target;
    
    private static final String FILE_PATH = "/Users/hectorhernandez/Documents/CodigosErrorAPI.pdf";
    
    @BeforeClass
    public static void setUpClass() {
        client = ClientBuilder.newBuilder().readTimeout(12, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS).build();
        target = client.target("http://localhost:8080/java-ee-examples-ejb-examples-web/services/async/upload/pdf/cs");
    }
    
    @AfterClass
    public static void destroy() {
        client.close();
    }
    
    @Test
    public void shouldSendFile() {
        try {
            CompletionStage<String> csf = target.request().rx().post(Entity
                    .entity(new FileInputStream(new File(FILE_PATH)), MediaType.MULTIPART_FORM_DATA), String.class);
            csf.whenCompleteAsync((path, err) -> {
                if (Objects.isNull(err)) {
                    System.out.println("File aved on: "  + path);
                } else {
                    err.printStackTrace();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
