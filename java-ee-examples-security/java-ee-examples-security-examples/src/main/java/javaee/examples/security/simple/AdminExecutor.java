
/**
 * @Class AdminExecutor
 * @author Hector
 * @Created on Jun 16, 2019, 6:11:30 PM
 */

package javaee.examples.security.simple;

import javax.annotation.security.RunAs;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
@RunAs(Roles.ADMIN)
public class AdminExecutor implements RoleExecutor {

    @Override
    public void run(Executable executable) throws Exception {
        executable.execute();
    }

}
