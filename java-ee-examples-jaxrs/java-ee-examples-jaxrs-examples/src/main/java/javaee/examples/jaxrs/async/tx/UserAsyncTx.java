/*
* Classname:    UserAsyncTx.java
* Author:       Héctor Hernández Chávez
* Date:         26-jun-2019
*/
package javaee.examples.jaxrs.async.tx;

/**
 * @author Héctor Hernández Chávez
 */
public class UserAsyncTx {
    
    private Long id;
    private String name;

    public UserAsyncTx(Long id, String name) {
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
