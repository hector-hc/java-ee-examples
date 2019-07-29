/*
* Classname:    WSAuditMehod.java
* Author:       Héctor Hernández Chávez
* Date:         29-jul-2019
*/
package javaee.examples.cdi.interceptor.logger.ws;

import javaee.examples.cdi.interceptor.logger.Log;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * @author Héctor Hernández Chávez
 */
@Path("interceptor/audit-method")
public class WSAuditMehod {
    

    @GET
    @Log
    public Response doSomething() {
        return Response.ok("OK").build();
    }
}
