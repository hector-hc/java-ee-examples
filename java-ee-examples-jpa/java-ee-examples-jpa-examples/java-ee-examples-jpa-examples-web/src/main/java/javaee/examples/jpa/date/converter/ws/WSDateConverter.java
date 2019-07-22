
/**
 * @Class WSDateConverter
 * @author Hector
 * @Created on Jul 21, 2019, 8:18:28 PM
 */

package javaee.examples.jpa.date.converter.ws;

import java.net.URI;
import javaee.examples.jpa.date.converter.PersonServiceEJB;
import javaee.examples.jpa.entities.Person;
import javax.ejb.EJB;
import javax.transaction.Transactional;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("date-converter/person")
public class WSDateConverter {
    
    @EJB
    PersonServiceEJB personService;

    @GET
    @Path("{id: \\d+}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response findPersonById(@PathParam("id") Long id) {
        return personService.getPersonById(id).map(person -> Response.ok(person)
                .build()).orElseThrow(NotFoundException::new);
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Transactional(value = Transactional.TxType.REQUIRED, rollbackOn = { Exception.class })
    public Response createPerson(final Person person, final @Context UriInfo uriInfo) {
        if (person == null) {
            throw  new BadRequestException();
        }
        Long personCreatedId = personService.createPerson(person);
        URI uri = uriInfo.getAbsolutePathBuilder().path(personCreatedId.toString()).build();
        return Response.created(uri).build();
    }
}
