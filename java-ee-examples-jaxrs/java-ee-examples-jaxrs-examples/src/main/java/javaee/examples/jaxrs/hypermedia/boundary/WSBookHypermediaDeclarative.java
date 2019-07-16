/*
* Classname:    WSBookHypermediaDeclarative.java
* Author:       Héctor Hernández Chávez
* Date:         16-jul-2019
*/
package javaee.examples.jaxrs.hypermedia.boundary;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import javaee.examples.jaxrs.hypermedia.entity.Book;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * @author Héctor Hernández Chávez
 */
@Path("hypermedia/declarative")
public class WSBookHypermediaDeclarative {

    @Inject
    BookStore bookStore;
    
    @Context
    UriInfo uriInfo;
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Book> getBooks() {
        List<Book> books = bookStore.get();
        books.forEach(this::addLinks);
        return books;
    }
    
    @GET
    @Path("{id: \\d+}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getBook(@PathParam("id") long id) {
        Optional<Book> optBook = bookStore.getById(id);
        if (optBook.isPresent()) {
            return Response.ok(optBook.get()).build();
        } else {
            throw new NotFoundException();
        }
    }
    
    private void addLinks(Book book) {
        URI selftUri = uriInfo.getBaseUriBuilder().path(WSBookHypermediaDeclarative.class)
                .path(WSBookHypermediaDeclarative.class, "getBook").build(book.getId());
        book.getLinks().put("self", selftUri);
    }
}
