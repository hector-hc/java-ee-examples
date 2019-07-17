/*
* Classname:    WSReportAsync.java
* Author:       Héctor Hernández Chávez
* Date:         17-jul-2019
*/
package javaee.examples.ejb.async.ws;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import javaee.examples.ejb.async.future.ReportFutureBuilder;
import javaee.examples.ejb.async.simple.ReportBuilder;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Héctor Hernández Chávez
 */
@Path("ejb/sync/report")
public class WSReportAsync {

    @EJB
    private ReportBuilder reportBuilder;
    
    @EJB
    private ReportFutureBuilder reportFutureBuilder;
    
    @GET
    @Path("simple")
    @Produces({MediaType.TEXT_PLAIN})
    public Response buildReport() {
        reportBuilder.buildReport();
        return Response.ok("Request accepted...").build();
    }
    
    @GET
    @Path("future")
    @Produces({MediaType.TEXT_PLAIN})
    public void buildFutureReport(@Suspended AsyncResponse response) {
        try {
            Future<String> resultFuture = reportFutureBuilder.buildReport();
            while (!resultFuture.isDone()) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException ie) {
                    System.err.println("" + ie.getMessage());
                    response.resume(Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                            .entity(ie.getMessage()).build());
                }
            }
            response.resume(Response.ok(resultFuture.get()).build());
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("" + e.getMessage());
            response.resume(Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                            .entity(e.getMessage()).build());
        }
    }
}
