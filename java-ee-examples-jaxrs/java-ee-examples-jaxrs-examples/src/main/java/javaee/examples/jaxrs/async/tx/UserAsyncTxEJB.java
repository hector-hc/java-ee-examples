/*
* Classname:    UserAsyncTxEJB.java
* Author:       Héctor Hernández Chávez
* Date:         26-jun-2019
*/
package javaee.examples.jaxrs.async.tx;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.ejb.Stateless;

/**
 * @author Héctor Hernández Chávez
 */
//@Stateless
public class UserAsyncTxEJB {

    public UserAsyncTx getUser() {
        try {
            TimeUnit.SECONDS.sleep(5);
            long id = new Date().getTime();
            return new UserAsyncTx(id, "User Tx " + id);
        } catch (InterruptedException ie) {
            System.err.println("" + ie.getMessage());
            long id = new Date().getTime();
            return new UserAsyncTx(id, "Error User Tx " + id);
        }
    }
}
