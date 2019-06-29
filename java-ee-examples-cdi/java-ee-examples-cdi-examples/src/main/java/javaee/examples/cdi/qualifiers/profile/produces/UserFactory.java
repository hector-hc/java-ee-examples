
/**
 * @Class UserFactory
 * @author Hector
 * @Created on Jun 17, 2019, 9:44:38 PM
 */

package javaee.examples.cdi.qualifiers.profile.produces;

import javaee.examples.cdi.qualifiers.profile.User;
import javax.enterprise.inject.Produces;


public class UserFactory {

    @Produces
    public User createUser() {
        return new User("hector", "hector.hdez.chavez@gmail.com");
    }
}
