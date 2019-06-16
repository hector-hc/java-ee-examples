
/**
 * @Class UserBean
 * @author Hector
 * @Created on Jun 16, 2019, 3:27:52 PM
 */

package javaee.examples.mvc.beans;

import javaee.examples.mvc.model.User;
import javax.ejb.Stateless;

@Stateless
public class UserBean {

    public User getUser() {
        return new User("hector", "hector@gmail.com");
    }
}
