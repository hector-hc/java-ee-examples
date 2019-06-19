/*
* Classname:    WSCacheCountry.java
* Author:       Héctor Hernández Chávez
* Date:         18-jun-2019
*/
package javaee.examples.ejb.ws;

import javaee.examples.ejb.cache.entities.singleton.CountryCacheEJB;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Héctor Hernández Chávez
 */
@Path("cache")
public class WSCacheCountry {
    
    @EJB
    private CountryCacheEJB countryCacheEJB;

    @GET
    @Path("countries")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getCountries() {
        return Response.ok().entity(countryCacheEJB.get()).build();
    }
}
