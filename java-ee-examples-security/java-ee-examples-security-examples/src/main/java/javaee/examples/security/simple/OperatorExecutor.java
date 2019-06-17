
/**
 * @Class OperatorExecutor
 * @author Hector
 * @Created on Jun 16, 2019, 6:12:12 PM
 */

package javaee.examples.security.simple;

import javax.annotation.security.RunAs;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
@RunAs(Roles.OPERATOR)
public class OperatorExecutor implements RoleExecutor {

    @Override
    public void run(Executable executable) throws Exception {
        executable.execute();
    }

}
