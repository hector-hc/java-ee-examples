
/**
 * @Class ProducerUser
 * @author Hector
 * @Created on Jun 16, 2019, 3:56:09 PM
 */

package javaee.examples.mvc.producers;

import javaee.examples.mvc.model.User;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;

//@RequestScoped
public class ProducerUser {

    //@Produces
    public User createUser() {
        return new User();
    }
}
