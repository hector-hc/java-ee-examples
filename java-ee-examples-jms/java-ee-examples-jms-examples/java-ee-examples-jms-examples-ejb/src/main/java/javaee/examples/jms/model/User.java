/**
 * @Class User
 * @author Hector
 * @Created on Jun 30, 2019, 8:50:39 AM
 */
package javaee.examples.jms.model;

import java.io.Serializable;

public class User implements Serializable {

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
