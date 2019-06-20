/*
* Classname:    UserLifeCycle.java
* Author:       Héctor Hernández Chávez
* Date:         20-jun-2019
 */
package javaee.examples.servlets.simple;

/**
 * @author Héctor Hernández Chávez
 */
public class UserLifeCycle {

    private String name;
    private String email;

    public UserLifeCycle(String name, String email) {
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
