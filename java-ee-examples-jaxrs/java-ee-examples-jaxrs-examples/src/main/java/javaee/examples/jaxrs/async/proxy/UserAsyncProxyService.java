/**
 * @Class UserAsyncProxyService
 * @author Hector
 * @Created on Jun 29, 2019, 9:55:48 AM
 */
package javaee.examples.jaxrs.async.proxy;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class UserAsyncProxyService {

    public UserAsyncProxy getUser() {
        try {
            TimeUnit.SECONDS.sleep(5);
            long id = new Date().getTime();
            return new UserAsyncProxy(id, "User " + id);
        } catch (InterruptedException ex) {
            long id = new Date().getTime();
            return new UserAsyncProxy(id, "Error " + id);
        }
    }
}
