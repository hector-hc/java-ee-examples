/*
* Classname:    CountryEJB.java
* Author:       Héctor Hernández Chávez
* Date:         19-jun-2019
*/
package javaee.examples.jpa.ejbs;

import java.util.List;
import javaee.examples.jpa.entities.Country;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Héctor Hernández Chávez
 */
@Stateless
public class CountryEJB {

    @PersistenceContext(name = "ejbExamplesPU")
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
