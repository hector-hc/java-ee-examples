/*
* Classname:    WSCacheCountry.java
* Author:       Héctor Hernández Chávez <hector.hernandez@conceptomovil.com>
* Date:         18-jun-2019
* © Concepto Móvil S.A. de C.V. 2014
*/
package javaee.examples.cache.ws;

import javaee.examples.cache.entities.singleton.CountryCacheEJB;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Héctor Hernández Chávez <hector.hernandez@conceptomovil.com>
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
