/**
 * @Class User
 * @author Hector
 * @Created on Jun 29, 2019, 10:20:07 AM
 */
package javaee.examples.servlets.async.cdi;

public class User {

    private Long id;
    private String name;

    public User(long id, String name) {
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
}
