
/**
 * @Class Role3Executor
 * @author Hector
 * @Created on Jun 23, 2019, 9:21:31 AM
 */

package javaee.examples.security.authorization;

import javax.annotation.security.RunAs;
import javax.inject.Named;

//@Named
//@RunAs(Roles.ROLE3)
public class Role3Executor implements RoleExecutable {

    @Override
    public void run(Executable executable) throws Exception {
        executable.execute();
    }

}
