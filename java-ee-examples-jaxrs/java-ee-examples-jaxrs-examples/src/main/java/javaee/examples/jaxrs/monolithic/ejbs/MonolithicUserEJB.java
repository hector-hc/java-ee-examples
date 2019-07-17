/**
 * @Class MonoUserEJB
 * @author Hector
 * @Created on Jun 24, 2019, 8:24:01 AM
 */
package javaee.examples.jaxrs.monolithic.ejbs;

import java.util.List;
import javaee.examples.jaxrs.monolithic.entities.MonolithicUser;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Stateless
public class MonolithicUserEJB {

    @PersistenceContext
    private EntityManager em;

    public Long add(MonolithicUser user) {
        em.persist(user);
        return user.getId();
    }

    public void remove(MonolithicUser user) {
        em.remove(user);
    }

    public void update(MonolithicUser user) {
        em.merge(user);
    }

    public MonolithicUser findById(Long id) {
        return em.find(MonolithicUser.class, id);
    }

    public List<MonolithicUser> get() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<MonolithicUser> cq = cb.createQuery(MonolithicUser.class);
        Root<MonolithicUser> pet = cq.from(MonolithicUser.class);
        cq.select(pet);
        TypedQuery<MonolithicUser> q = em.createQuery(cq);
        return q.getResultList();
    }
}
