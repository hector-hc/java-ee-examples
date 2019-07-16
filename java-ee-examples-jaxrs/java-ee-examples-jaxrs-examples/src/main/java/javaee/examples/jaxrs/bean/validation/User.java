/*
* Classname:    User.java
* Author:       Héctor Hernández Chávez
* Date:         16-jul-2019
*/
package javaee.examples.jaxrs.bean.validation;

import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTransient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * @author Héctor Hernández Chávez
 */
public class User {

    @JsonbTransient
    private long id;
    
    @NotBlank
    @UserNameNotTaken
    @JsonbProperty("username")
    private String name;
    
    @Email
    private String email;
    
    public User() {
    }
    
    public User(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
