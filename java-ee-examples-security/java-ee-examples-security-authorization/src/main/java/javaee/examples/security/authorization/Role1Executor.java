
/**
 * @Class Role1Executor
 * @author Hector
 * @Created on Jun 23, 2019, 9:19:23 AM
 */

package javaee.examples.security.authorization;

import javax.annotation.security.RunAs;
import javax.inject.Named;

//@Named
//@RunAs(Roles.ROLE1)
public class Role1Executor implements RoleExecutable {

    @Override
    public void run(Executable executable) throws Exception {
        executable.execute();
    }

}
