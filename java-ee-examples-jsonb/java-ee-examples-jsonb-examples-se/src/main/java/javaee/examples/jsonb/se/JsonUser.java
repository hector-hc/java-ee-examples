
/**
 * @Class JsonUser
 * @author Hector
 * @Created on Jun 16, 2019, 2:47:06 PM
 */

package javaee.examples.jsonb.se;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

public class JsonUser {

    public static void main(String[] args) throws Exception {
        User user = new User("hector", "hector@gmail.com");
        Jsonb jb = JsonbBuilder.create();
        String jsonUser = jb.toJson(user);
        User u = jb.fromJson(jsonUser, User.class);
        
        jb.close();
        
        System.out.println("json: " + jsonUser);
        System.out.println("user: " + u);
    }
}
