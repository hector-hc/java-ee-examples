
/**
 * @Class UserBean
 * @author Hector
 * @Created on Jun 23, 2019, 2:31:46 PM
 */

package javaee.examples.security.declarative;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateful;

@Stateful
public class UserBean {

    @RolesAllowed({Roles.ADMIN})
    public void adminOperation() {
        System.out.println("adminOperation executed");
    }
    
    @RolesAllowed({Roles.USER})
    public void userOperation() {
        System.out.println("userOperation executed");
    }
    
    @PermitAll
    public void everyneCanDo() {
        System.out.println("everyCanDo executed");
    }
    
    @DenyAll
    public void noneCanDo() {
        System.out.println("noneCanDo executed");
    }
}
