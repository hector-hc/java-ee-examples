/*
* Classname:    WSJPACountry.java
* Author:       Héctor Hernández Chávez
* Date:         19-jun-2019
*/
package javaee.examples.jpa.ws;

import java.net.URI;
import java.util.List;
import javaee.examples.jpa.ejbs.CountryEJB;
import javaee.examples.jpa.entities.Country;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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
@Path("country")
public class WSJPACountry {

    @EJB
    private CountryEJB countryEJB;
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response saveCountry(@Context UriInfo uriInfo, final Country country) {
        Long id = countryEJB.add(country);
        URI countryUri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(id)).build();
        return Response.created(countryUri).build();
    }
    
    @PUT
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response updateCountry(@Context UriInfo uriInfo, final Country country) {
        countryEJB.update(country);
        URI countryUri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(country.getId())).build();
        return Response.accepted(country).build();
    }
    
    @DELETE
    @Path("{id: \\d+}")
    public Response deleteCountry(@PathParam("id") Long id) {
        Country country = countryEJB.findById(id);
        if (country == null) {
            throw new NotFoundException();
        }
        countryEJB.remove(country);
        return Response.noContent().build();
    }
    
    @GET
    @Path("{id: \\d+}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getCountry(@PathParam("id") Long id) {
        Country country = countryEJB.findById(id);
        if (country == null) {
            throw new NotFoundException();
        }
        return Response.ok(country).build();
    }
    
    @GET
    public Response getCountries() {
        List<Country> countries = countryEJB.findAll();
        return Response.ok(countries).build();
    }
}
