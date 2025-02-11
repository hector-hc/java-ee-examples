
/**
 * @Class UserActivity
 * @author Hector
 * @Created on Jun 23, 2019, 9:07:11 AM
 */

package javaee.examples.security.authorization;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateful;

@Stateful
public class UserActivity {

    @RolesAllowed({Roles.ROLE1})
    public void role1Allowed() {
        System.out.println("role1Allowed executed");
    }
    
    @RolesAllowed({Roles.ROLE2})
    public void role2Allowed() {
        System.out.println("role2Allowed executed");
    }
    
    @RolesAllowed({Roles.ROLE3})
    public void role3Allowed() {
        System.out.println("role3Allowed executed");
    }
    
    @PermitAll
    public void anonymousAllowed() {
        System.out.println("anonymousAllowed executed");
    }
    
    @DenyAll
    public void noOneAllowed() {
        System.out.println("noOneAllowed executed");
    }
}
