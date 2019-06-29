
/**
 * @Class UserAsyncScheduledService
 * @author Hector
 * @Created on Jun 29, 2019, 9:28:07 AM
 */

package javaee.examples.jaxrs.async.scheduled;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class UserAsyncScheduledService {

    public UserAsyncScheduled getUser() {
        try {
            TimeUnit.SECONDS.sleep(5);
            long id = new Date().getTime();
            return new UserAsyncScheduled(id, "User_" + id);
        } catch (InterruptedException ie) {
            long id = new Date().getTime();
            return new UserAsyncScheduled(id, "Error_" + id);
        }
    }
}
