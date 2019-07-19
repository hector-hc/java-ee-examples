/**
 * @Class UserCompletableFuture
 * @author Hector
 * @Created on Jun 30, 2019, 1:30:27 PM
 */
package javaee.examples.jaxrs.async.completablefuture;

import java.io.Serializable;

public class UserAsyncCompletableFuture implements Serializable {

    private Long id;
    private String name;

    public UserAsyncCompletableFuture(long id, String name) {
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
