
/**
 * @Class UserBean
 * @author Hector
 * @Created on Jun 16, 2019, 2:15:14 PM
 */

package javaee.examples.jsf.validator;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@RequestScoped
public class UserBean implements Serializable {

    private User user;
    
    @PostConstruct
    public void init() {
        user = new User("Hector Hernandez", "hector.hdez.chavez@gmail.com");
    }
    
    public UserBean() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public void userAction() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Name|Password welformed"));
    }
}
