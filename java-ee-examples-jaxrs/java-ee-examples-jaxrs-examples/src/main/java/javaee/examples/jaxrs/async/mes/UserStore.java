/*
* Classname:    UserStore.java
* Author:       Héctor Hernández Chávez
* Date:         17-jul-2019
*/
package javaee.examples.jaxrs.async.mes;

import java.util.concurrent.TimeUnit;

/**
 * @author Héctor Hernández Chávez
 */
public class UserStore {

    public long create(User user) {
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException ie) {
            System.err.println("InterruptedException " + ie.getMessage());
        }
        return 1;
    }
}
