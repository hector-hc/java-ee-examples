/**
 * @Class User
 * @author Hector
 * @Created on Jun 16, 2019, 2:46:12 PM
 */
package javaee.examples.jsonb.se;

public class User {

    private String name;
    private String email;

    public User() {

    }

    public User(String name, String email) {
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
