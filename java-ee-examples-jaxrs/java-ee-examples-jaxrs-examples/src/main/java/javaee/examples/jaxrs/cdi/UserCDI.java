
/**
 * @Class UserCDI
 * @author Hector
 * @Created on Jun 22, 2019, 7:44:47 PM
 */

package javaee.examples.jaxrs.cdi;

public class UserCDI {
    private String name;
    private String email;

    public UserCDI(){ 
    }
    
    public UserCDI(String name, String email) {
        this.name = name;
        this.email = email;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public String toString() {
        return "User{" + "name=" + name + ", email=" + email + '}';
    }
}
