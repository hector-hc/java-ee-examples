/*
* Classname:    User.java
* Author:       Héctor Hernández Chávez
* Date:         17-jul-2019
*/
package javaee.examples.jaxrs.async.mes;

import javax.json.bind.annotation.JsonbTransient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Héctor Hernández Chávez
 */
public class User {

    @JsonbTransient
    private long id;
    
    @NotBlank
    @NotNull
    private String name;
    
    @Email
    @NotBlank
    @NotNull
    private String email;
    
    public User() {
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
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
