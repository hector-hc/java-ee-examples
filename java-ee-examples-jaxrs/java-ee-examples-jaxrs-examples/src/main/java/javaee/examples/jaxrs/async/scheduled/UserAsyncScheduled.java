
/**
 * @Class UserAsyncScheduled
 * @author Hector
 * @Created on Jun 29, 2019, 9:25:31 AM
 */

package javaee.examples.jaxrs.async.scheduled;

public class UserAsyncScheduled {
    
    public UserAsyncScheduled(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    
    private Long id;
    private String name;

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
