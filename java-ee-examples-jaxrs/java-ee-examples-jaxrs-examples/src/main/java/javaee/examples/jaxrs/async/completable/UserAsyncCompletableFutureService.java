
/**
 * @Class UserCompletableFutureService
 * @author Hector
 * @Created on Jun 30, 2019, 1:31:19 PM
 */

package javaee.examples.jaxrs.async.completable;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class UserAsyncCompletableFutureService {

    public UserAsyncCompletableFuture getUser() {
        long id = new Date().getTime();
        try {
            TimeUnit.SECONDS.sleep(5);
            return new UserAsyncCompletableFuture(id, "User_" + id);
        } catch (InterruptedException ie) {
            System.err.println("" + ie.getMessage());
            return new UserAsyncCompletableFuture(id, "Error_" + id);
        }
    }
}
