
/**
 * @interface RoleExecutable
 * @Author Hector
 * @Created on Jun 23, 2019, 2:23:17 PM
 */

package javaee.examples.security.declarative;

public interface RoleExecutable {

    public interface Executable {
        void execute() throws Exception;
    }    
    
    void run(Executable executable) throws Exception; 
}
