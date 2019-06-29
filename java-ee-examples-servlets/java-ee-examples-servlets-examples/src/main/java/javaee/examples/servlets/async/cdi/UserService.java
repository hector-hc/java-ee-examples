/**
 * @Class UserService
 * @author Hector
 * @Created on Jun 29, 2019, 10:20:33 AM
 */
package javaee.examples.servlets.async.cdi;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class UserService {

    public User getUser() {
        long id = new Date().getTime();
        try {
            TimeUnit.SECONDS.sleep(5);
            return new User(id, "User " + id);
        } catch (InterruptedException ex) {
            System.err.println(ex.getMessage());
            return new User(id, "Error " + id);
        }
    }
}
