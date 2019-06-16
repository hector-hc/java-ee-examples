/**
 * @Class User
 * @author Hector
 * @Created on Jun 16, 2019, 2:13:03 PM
 */
package javaee.examples.jsf.validator;

import java.io.Serializable;

public class User implements Serializable {

    private String name;
    private String email;

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
}
