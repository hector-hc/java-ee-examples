
/**
 * @Class MonoUserAddressEJB
 * @author Hector
 * @Created on Jun 24, 2019, 8:19:11 AM
 */

package javaee.examples.jaxrs.monolithic.ejbs;

import java.util.List;
import javaee.examples.jaxrs.monolithic.entities.MonolithicUserAddress;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Stateless
public class MonolithicUserAddressEJB {

    @PersistenceContext
    private EntityManager em;
    
    public Long add(MonolithicUserAddress address) {
        em.persist(address);
        return address.getId();
    }
    
    public void remove(MonolithicUserAddress address) {
        em.remove(address);
    }
    
    public void update(MonolithicUserAddress address) {
        em.merge(address);
    }
    
    public MonolithicUserAddress findById(final Long id) {
        return em.find(MonolithicUserAddress.class, id);
    }
    
    public List<MonolithicUserAddress> getAll() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<MonolithicUserAddress> cq = cb.createQuery(MonolithicUserAddress.class);
        Root<MonolithicUserAddress> pet = cq.from(MonolithicUserAddress.class);
        cq.select(pet);
        TypedQuery<MonolithicUserAddress> q = em.createQuery(cq);
        return q.getResultList();
    }
}
