/*
* Classname:    CountryStatefulEJB.java
* Author:       Héctor Hernández Chávez
* Date:         20-jun-2019
*/
package javaee.examples.jpa.ejbs;

import java.util.List;
import javaee.examples.jpa.entities.Country;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 * @author Héctor Hernández Chávez
 */
@Stateful
public class CountryStatefulEJB {
    
    @PersistenceContext(name = "ejbExamplesPU", type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;
    
    public Long add(Country country) { 
        entityManager.persist(country);
        return country.getId();
    }
    
    public void update(Country country) {
        entityManager.merge(country);
    }
    
    public void remove(Country country) {
        entityManager.remove(country);
    }
    
    public Country findById(final Long id) {
        return entityManager.find(Country.class, id);
    }
    
    public List<Country> findAll() {
        return entityManager.createNamedQuery(Country.FIND_ALL).getResultList();
    }
}
