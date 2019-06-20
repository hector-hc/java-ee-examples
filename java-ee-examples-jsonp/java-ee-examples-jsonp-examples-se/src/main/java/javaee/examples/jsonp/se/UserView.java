/*
* Classname:    UserView.java
* Author:       Héctor Hernández Chávez
* Date:         20-jun-2019
*/
package javaee.examples.jsonp.se;

import java.math.BigDecimal;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonBuilderFactory;
import javax.json.JsonPointer;
import javax.json.JsonStructure;
import javax.json.JsonValue;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;

/**
 * @author Héctor Hernández Chávez
 */
public class UserView {

    private static final JsonBuilderFactory JSON_BUILDER_FACTORY = Json.createBuilderFactory(null);
    
    public static void main(String[] args) throws Exception {
        JsonbConfig jsonbConfig = new JsonbConfig();
        jsonbConfig.withFormatting(Boolean.TRUE);
        try (Jsonb jsonb = JsonbBuilder.create(jsonbConfig)) {
            
            String jsonArray = jsonb.toJson(buildJsonArray());
            System.out.println("" + jsonArray);
            
            JsonStructure jStructure = buildJsonStructure();
            
            String jsonStrStructure = jsonb.toJson(jStructure);
            
            System.out.println("" + jsonStrStructure);
            
            JsonPointer pointer = Json.createPointer("/profiles");
            JsonValue value = pointer.getValue(jStructure);
            
            System.out.println("" + value);
            
            User user = buildUser();
            
            String jsonUser = jsonb.toJson(user);
            
            System.out.println("" + jsonUser);
        }
    }
    
    private static JsonArray buildJsonArray() {
        JsonArray array = JSON_BUILDER_FACTORY.createArrayBuilder()
                .add(JSON_BUILDER_FACTORY.createObjectBuilder().add("name", "User01").add("email", "user01@gmail.com"))
                .add(JSON_BUILDER_FACTORY.createObjectBuilder().add("name", "User02").add("email", "user02@gmail.com"))
                .add(JSON_BUILDER_FACTORY.createObjectBuilder().add("name", "User02").add("email", "user02@gmail.com"))
                .build();
        return array;
    }
    
    private static JsonStructure buildJsonStructure() {
        JsonStructure structure = JSON_BUILDER_FACTORY.createObjectBuilder()
                .add("name", "User01")
                .add("emil", "user01@gmail.com")
                .add("profiles", JSON_BUILDER_FACTORY.createArrayBuilder()
                    .add(JSON_BUILDER_FACTORY.createObjectBuilder()
                        .add("id", "1")
                        .add("name", "Profile1"))
                    .add(JSON_BUILDER_FACTORY.createObjectBuilder()
                        .add("id", "1")
                        .add("name", "Profile2")))
                .build();
        return structure;
    }
    
    private static User buildUser() {
        User user = new User("Hector", "hector@gmail.com", new Integer[]{1, 2, 3});
        return user;
    }
}
