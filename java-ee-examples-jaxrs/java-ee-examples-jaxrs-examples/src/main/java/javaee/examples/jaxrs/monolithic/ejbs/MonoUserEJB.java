/**
 * @Class MonoUserEJB
 * @author Hector
 * @Created on Jun 24, 2019, 8:24:01 AM
 */
package javaee.examples.jaxrs.monolithic.ejbs;

import java.util.List;
import javaee.examples.jaxrs.monolithic.entities.MonoUser;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Stateless
public class MonoUserEJB {

    @PersistenceContext
    private EntityManager em;

    public Long add(MonoUser user) {
        em.persist(user);
        return user.getId();
    }

    public void remove(MonoUser user) {
        em.remove(user);
    }

    public void update(MonoUser user) {
        em.merge(user);
    }

    public MonoUser findById(Long id) {
        return em.find(MonoUser.class, id);
    }

    public List<MonoUser> get() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<MonoUser> cq = cb.createQuery(MonoUser.class);
        Root<MonoUser> pet = cq.from(MonoUser.class);
        cq.select(pet);
        TypedQuery<MonoUser> q = em.createQuery(cq);
        return q.getResultList();
    }
}
