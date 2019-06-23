
/**
 * @Class UserEJB
 * @author Hector
 * @Created on Jun 22, 2019, 7:45:45 PM
 */

package javaee.examples.jaxrs.cdi;

import javax.ejb.Stateless;

@Stateless
public class UserEJB {

    public UserCDI getUserCDI() {
        long ts = System.currentTimeMillis();
        return new UserCDI("UserEJB" + ts, ts + "@gmail.com");
    }
}
