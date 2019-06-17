
/**
 * @Class UserBean
 * @author Hector
 * @Created on Jun 16, 2019, 6:17:59 PM
 */

package javaee.examples.security.simple;

import java.security.Principal;
import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJBContext;
import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.security.enterprise.SecurityContext;

@Stateful
public class UserBean {
    
    @Inject
    private Principal principal;
    
    @Inject
    private SecurityContext securityCtx;
    
    @Resource
    private EJBContext ejbCtx;

    @RolesAllowed({Roles.ADMIN, Roles.OPERATOR})
    public void add(User user) {
        System.out.println("add_user::" + principal.getName() + " - " + securityCtx.isCallerInRole("ADMIN") + " - " + ejbCtx.isCallerInRole("ADMIN"));
    }
}
