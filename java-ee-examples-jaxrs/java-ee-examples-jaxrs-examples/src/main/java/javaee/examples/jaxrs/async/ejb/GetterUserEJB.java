
/**
 * @Class GetterUserEJB
 * @author Hector
 * @Created on Jun 30, 2019, 1:15:16 PM
 */

package javaee.examples.jaxrs.async.ejb;

import java.util.Date;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;

@Stateless
public class GetterUserEJB {

    @Asynchronous
    public Future<UserAsyncEjb> getUser() {
        long id = new Date().getTime();
        UserAsyncEjb user = new UserAsyncEjb(id, "User_" + id);
        return new AsyncResult(user);
    }
    
    @Asynchronous
    public void doMeSlowStuff(UserAsyncEjb user) {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException ie) {
            System.err.println("" + ie.getMessage());
        }
    }
}
