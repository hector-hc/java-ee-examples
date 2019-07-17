/*
* Classname:    WSPeriodicMSES.java
* Author:       Héctor Hernández Chávez
* Date:         17-jul-2019
*/
package javaee.examples.ejb.mses.ws;

import javaee.examples.ejb.scheduled.mses.Periodic;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Héctor Hernández Chávez
 */
@Path("periodic/mses")
public class WSPeriodicMSES {

    @Inject
    Periodic periodic;
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response startScheludedPeriodic() {
        periodic.startasyncJobs();
        return Response.ok("OK").build();
    }
}
