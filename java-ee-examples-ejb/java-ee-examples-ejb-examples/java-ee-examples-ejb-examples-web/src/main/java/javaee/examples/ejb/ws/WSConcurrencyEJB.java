/*
* Classname:    WSConcurrencyEJB.java
* Author:       Héctor Hernández Chávez
* Date:         19-jun-2019
*/
package javaee.examples.ejb.ws;

import javaee.examples.ejb.concurrency.CountryClassLeveEJB;
import javaee.examples.ejb.concurrency.CountryMethodLevelEJB;
import javaee.examples.ejb.concurrency.CountrySelftManagedEJB;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * @author Héctor Hernández Chávez
 */
@Path("concurrency")
public class WSConcurrencyEJB {

    @EJB
    private CountryClassLeveEJB countryClassLevelEJB;
    
    @EJB
    private CountryMethodLevelEJB countryMethodLevelEJB;
    
    @EJB
    private CountrySelftManagedEJB countrySelftEJB;
    
    @GET
    @Path("level/class")
    public Response getCountryClassLevel() {
        countryClassLevelEJB.addCountry();
        int count = countryClassLevelEJB.getCountryCount();
        return Response.ok(count).build();
    }
    
    @GET
    @Path("level/method")
    public Response getCountryMethodLevel() {
        countryMethodLevelEJB.addCountry();
        int count = countryMethodLevelEJB.getCountryCount();
        return Response.ok(count).build();
    }
    
    @GET
    @Path("level/selft")
    public Response getCountrySelftLevel() {
        countrySelftEJB.addCountry();
        int count = countrySelftEJB.getCountryCount();
        return Response.ok(count).build();
    }
}
