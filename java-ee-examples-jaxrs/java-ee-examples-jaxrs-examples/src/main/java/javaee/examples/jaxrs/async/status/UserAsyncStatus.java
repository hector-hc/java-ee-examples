/*
* Classname:    UserAsyncStatus.java
* Author:       Héctor Hernández Chávez
* Date:         28-jun-2019
 */
package javaee.examples.jaxrs.async.status;

/**
 * @author Héctor Hernández Chávez
 */
public class UserAsyncStatus {

    private Long id;
    private String name;
    
    public UserAsyncStatus(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + '}';
    }
}
