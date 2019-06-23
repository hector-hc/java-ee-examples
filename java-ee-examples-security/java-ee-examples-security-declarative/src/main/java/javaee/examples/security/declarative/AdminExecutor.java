
/**
 * @Class AdminExecutor
 * @author Hector
 * @Created on Jun 23, 2019, 2:25:44 PM
 */

package javaee.examples.security.declarative;

public class AdminExecutor implements RoleExecutable {

    @Override
    public void run(Executable executable) throws Exception {
        executable.execute();
    }

}
