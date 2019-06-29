
/**
 * @Class UserAsyncManagedService
 * @author Hector
 * @Created on Jun 29, 2019, 9:04:01 AM
 */

package javaee.examples.jaxrs.async.managed;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class UserAsyncManagedService {

    public UserAsyncManaged getUser() {
        try {
            TimeUnit.SECONDS.sleep(5);
            long id = new Date().getTime();
            return new UserAsyncManaged(id, "User_" + id);
        } catch (InterruptedException ie) {
            long id = new Date().getTime();
            return new UserAsyncManaged(id, "Error_" + id);
        }
    }
}
