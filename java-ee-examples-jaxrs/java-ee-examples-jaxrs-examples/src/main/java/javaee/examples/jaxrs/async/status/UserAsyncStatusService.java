/*
* Classname:    UserAsyncStatusService.java
* Author:       Héctor Hernández Chávez
* Date:         28-jun-2019
*/
package javaee.examples.jaxrs.async.status;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author Héctor Hernández Chávez
 */
public class UserAsyncStatusService {

    public UserAsyncStatus getUser() {
        try {
            TimeUnit.SECONDS.sleep(5);
            long id = new Date().getTime();
            return new UserAsyncStatus(id, "User_" + id);
        } catch (InterruptedException ie) {
            long id = new Date().getTime();
            return new UserAsyncStatus(id, "Error_" + id);
        }
    }
}
