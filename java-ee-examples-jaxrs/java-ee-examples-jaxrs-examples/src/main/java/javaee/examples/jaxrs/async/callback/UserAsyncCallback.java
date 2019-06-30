/**
 * @Class UserAsyncCallback
 * @author Hector
 * @Created on Jun 30, 2019, 12:48:42 PM
 */
package javaee.examples.jaxrs.async.callback;

import java.io.Serializable;

public class UserAsyncCallback implements Serializable {

    private Long id;
    private String name;

    public UserAsyncCallback(long id, String name) {
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
