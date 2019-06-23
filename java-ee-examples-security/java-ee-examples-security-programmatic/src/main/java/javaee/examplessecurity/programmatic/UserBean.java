
/**
 * @Class UserBean
 * @author Hector
 * @Created on Jun 23, 2019, 3:11:35 PM
 */

package javaee.examplessecurity.programmatic;

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
    public void everyoneCanDo(){
        System.out.println("everyoneCanDo executed");
    }
}
