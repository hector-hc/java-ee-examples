
/**
 * @Class Role2Executor
 * @author Hector
 * @Created on Jun 23, 2019, 9:20:33 AM
 */

package javaee.examples.security.authorization;

import javax.annotation.security.RunAs;
import javax.inject.Named;

//@Named
//@RunAs(Roles.ROLE2)
public class Role2Executor implements RoleExecutable {

    @Override
    public void run(Executable executable) throws Exception {
        executable.execute();
    }

}
