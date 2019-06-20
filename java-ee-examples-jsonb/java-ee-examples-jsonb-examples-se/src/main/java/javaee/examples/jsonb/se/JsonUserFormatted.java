/*
* Classname:    JsonUserFormatted.java
* Author:       Héctor Hernández Chávez
* Date:         20-jun-2019
*/
package javaee.examples.jsonb.se;

import java.util.Date;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;

/**
 * @author Héctor Hernández Chávez
 */
public class JsonUserFormatted {
    public static void main(String[] args) throws Exception {
        long now = System.currentTimeMillis();
        UserFormatted user = new UserFormatted(now, "user_" + now, "user_" + now 
                + "@gmail.com", Math.random(), new Date());
        JsonbConfig jsonConfig = new JsonbConfig();
        jsonConfig.withFormatting(Boolean.TRUE);
        try (Jsonb jsonb = JsonbBuilder.create(jsonConfig)) {
            String userJsonFormatted = jsonb.toJson(user);
            System.out.println("" + userJsonFormatted);
        }
    }
}
