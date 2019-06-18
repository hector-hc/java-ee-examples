/**
 * @Class User
 * @author Hector
 * @Created on Jun 17, 2019, 9:45:14 PM
 */
package javaee.examples.cdi.profile;

public class User {

    private String name;
    private String email;

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

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" + "name=" + name + ", email=" + email + '}';
    }
}
