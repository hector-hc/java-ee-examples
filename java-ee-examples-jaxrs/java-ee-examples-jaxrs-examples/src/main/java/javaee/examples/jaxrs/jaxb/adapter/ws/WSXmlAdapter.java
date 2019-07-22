/*
* Classname:    WSXmlAdapter.java
* Author:       Héctor Hernández Chávez
* Date:         22-jul-2019
*/
package javaee.examples.jaxrs.jaxb.adapter.ws;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javaee.examples.jaxrs.jaxb.adapter.Schedule;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Héctor Hernández Chávez
 */
@Path("xml-adapter")
public class WSXmlAdapter {

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getShedule() {
        Schedule schedule = new Schedule();
        schedule.setShiftEndDate(LocalDate.now());
        schedule.setShiftStartDate(LocalDate.now());
        schedule.setShiftStartTime(LocalDateTime.now());
        schedule.setShiftEndTime(LocalDateTime.now());
        return Response.ok(schedule).build();
    }
}
