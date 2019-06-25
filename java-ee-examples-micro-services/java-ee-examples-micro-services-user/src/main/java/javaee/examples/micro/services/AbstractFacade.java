
/**
 * @Class AbstractFacade
 * @author Hector
 * @Created on Jun 24, 2019, 8:28:38 PM
 */

package javaee.examples.micro.services;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.Root;
public abstract class AbstractFacade<T> {

    private final Class<T> entityClass;
    
    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    
    protected abstract EntityManager getEntityManager();
    
    public void create(T entity) {
        getEntityManager().persist(entity);
    }
    
    public void edit(T entity) {
        getEntityManager().merge(entity);
    }
    
    public void remove(T entity) {
        getEntityManager().remove(entity);
    }
    
    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }
    
    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager()
                .getCriteriaBuilder().createQuery();
        Root<T> root = cq.from(entityClass);
        cq.select(root);
        return getEntityManager().createQuery(cq).getResultList();
    }
}
