
/**
 * @Class JPointer
 * @author Hector
 * @Created on Jun 16, 2019, 2:59:25 PM
 */

package javaee.examples.jsonp.se;

import java.io.IOException;
import java.io.InputStream;
import javax.json.Json;
import javax.json.JsonPointer;
import javax.json.JsonReader;
import javax.json.JsonStructure;
import javax.json.JsonValue;

public class JPointer {
    public static void main(String[] args) throws IOException {
        try (InputStream is = JPointer.class.getClassLoader().getResourceAsStream("user.json")
                ; JsonReader jr = Json.createReader(is)) {
            JsonStructure js = jr.read();
            JsonPointer jp = Json.createPointer("/user/profile");
            JsonValue jv = jp.getValue(js);
            System.out.println("profile: " + jv);
        }
    }
}
