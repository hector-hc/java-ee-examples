/*
* Classname:    EntityBuilder.java
* Author:       Héctor Hernández Chávez
* Date:         16-jul-2019
 */
package javaee.examples.jaxrs.hypermedia.boundary;

import java.net.URI;
import javaee.examples.jaxrs.hypermedia.entity.Book;
import javax.json.Json;
import javax.json.JsonObject;

/**
 * @author Héctor Hernández Chávez
 */
public class EntityBuilder {

    public JsonObject buildForBook(Book book, URI selfUri) {
        return Json.createObjectBuilder()
                .add("name", book.getName())
                .add("author", book.getName())
                .add("isbn", book.getName())
                .add("_links", Json.createObjectBuilder()
                        .add("self", selfUri.toString()))
                .build();
    }
}
