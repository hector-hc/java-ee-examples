/*
* Classname:    User.java
* Author:       Héctor Hernández Chávez
* Date:         20-jun-2019
 */
package javaee.examples.jsonp.se;

/**
 * @author Héctor Hernández Chávez
 */
public class User {

    private String name;
    private String email;
    private Integer[] profiles;

    public User(String name, String email, Integer[] profiles) {
        this.name = name;
        this.email = email;
        this.profiles = profiles;
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

    public Integer[] getProfiles() {
        return profiles;
    }

    public void setProfiles(Integer[] profiles) {
        this.profiles = profiles;
    }
}
