/*
* Classname:    WSBookHypermediaProgrammatic.java
* Author:       Héctor Hernández Chávez
* Date:         16-jul-2019
*/
package javaee.examples.jaxrs.hypermedia.boundary;

import java.net.URI;
import java.util.Optional;
import javaee.examples.jaxrs.hypermedia.entity.Book;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.stream.JsonCollectors;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * @author Héctor Hernández Chávez
 */
@Path("hypermedia/programmatic")
public class WSBookHypermediaProgrammatic {

    @Inject
    BookStore bookStore;
    
    @Context
    UriInfo uriInfo;
    
    @GET
    public JsonArray getBooks() {
        return bookStore.get().stream().map(this::buildBookJson)
                .collect(JsonCollectors.toJsonArray());
    }
    
    @GET
    @Path("{id: \\d+}")
    public JsonObject getBook(@PathParam("id") long id) {
        Optional<Book> optBook = bookStore.getById(id);
        if (optBook.isPresent()) {
            return buildBookJson(optBook.get());
        } else {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
                    
        }
    }
    
    private JsonObject buildBookJson(Book book) {
        URI selfUri = uriInfo.getBaseUriBuilder().path(WSBookHypermediaProgrammatic.class)
                .path(WSBookHypermediaProgrammatic.class, "getBook").build(book.getId());
        return Json.createObjectBuilder().add("name", book.getName())
                .add("author", book.getAuthor())
                .add("isbn", book.getIsbn())
                .add("_links", Json.createObjectBuilder()
                    .add("selft", selfUri.toString())).build();
    }
}
