
/**
 * @Class MonoUserAddressEJB
 * @author Hector
 * @Created on Jun 24, 2019, 8:19:11 AM
 */

package javaee.examples.jaxrs.monolithic.ejbs;

import java.util.List;
import javaee.examples.jaxrs.monolithic.entities.MonoUserAddress;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Stateless
public class MonoUserAddressEJB {

    @PersistenceContext
    private EntityManager em;
    
    public Long add(MonoUserAddress address) {
        em.persist(address);
        return address.getId();
    }
    
    public void remove(MonoUserAddress address) {
        em.remove(address);
    }
    
    public void update(MonoUserAddress address) {
        em.merge(address);
    }
    
    public MonoUserAddress findById(final Long id) {
        return em.find(MonoUserAddress.class, id);
    }
    
    public List<MonoUserAddress> getAll() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<MonoUserAddress> cq = cb.createQuery(MonoUserAddress.class);
        Root<MonoUserAddress> pet = cq.from(MonoUserAddress.class);
        cq.select(pet);
        TypedQuery<MonoUserAddress> q = em.createQuery(cq);
        return q.getResultList();
    }
}
