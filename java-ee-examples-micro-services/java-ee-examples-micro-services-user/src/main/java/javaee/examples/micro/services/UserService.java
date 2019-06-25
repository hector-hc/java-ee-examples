
/**
 * @Class UserServices
 * @author Hector
 * @Created on Jun 24, 2019, 8:27:43 PM
 */

package javaee.examples.micro.services;

import javaee.examples.micro.entities.MicroUser;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
public class UserService extends AbstractFacade<MicroUser> {
    
    @PersistenceContext
    private EntityManager em;
    
    public UserService() {
        super(MicroUser.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
