/*
* Classname:    WSEmployeeJsonbAdapter.java
* Author:       Héctor Hernández Chávez
* Date:         16-jul-2019
*/
package javaee.examples.jaxrs.jsonb.adapter.ws;

import javaee.examples.jaxrs.jsonb.adapter.Employee;
import javaee.examples.jaxrs.jsonb.adapter.Organization;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Héctor Hernández Chávez
 */
@Path("employee/jsonb/adapter")
public class WSEmployeeJsonbAdapter {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getEmployee() {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Hector");
        employee.setEmail("hector@gmail.com");
        Organization org = new Organization();
        org.setId(200);
        employee.setOrganization(org);
        return Response.ok(employee).build();
    }
}
