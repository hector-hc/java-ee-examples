
/**
 * @Class WSTransaction
 * @author Hector
 * @Created on Jun 23, 2019, 8:49:29 PM
 */

package javaee.examples.ejb.ws;

import javaee.examples.ejb.transactions.UserTxEJB;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("transaction")
public class WSTxUser {

    @EJB
    UserTxEJB userTxEJB;
    
    @GET
    public Response createTransaction() {
        userTxEJB.add(1);
        userTxEJB.add(2);
        userTxEJB.add(3);
        userTxEJB.remove(2);
        int size = userTxEJB.getActions().size();
        userTxEJB.logout();
        return Response.ok("size: " + size).build();
    }
}
