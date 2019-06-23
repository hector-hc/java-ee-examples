
/**
 * @Class UserExecutor
 * @author Hector
 * @Created on Jun 23, 2019, 2:21:02 PM
 */

package javaee.examples.security.declarative;

public class UserExecutor implements RoleExecutable {

    @Override
    public void run(Executable executable) throws Exception {
        executable.execute();
    }
    
}
