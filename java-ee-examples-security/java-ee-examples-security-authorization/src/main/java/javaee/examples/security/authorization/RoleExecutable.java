
/**
 * @interface RoleExecutable
 * @Author Hector
 * @Created on Jun 23, 2019, 9:17:25 AM
 */

package javaee.examples.security.authorization;

public interface RoleExecutable {
    void run(Executable executable) throws Exception;
}
