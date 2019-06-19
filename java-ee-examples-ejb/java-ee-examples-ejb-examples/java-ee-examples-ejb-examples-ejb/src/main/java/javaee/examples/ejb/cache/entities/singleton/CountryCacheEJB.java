/*
* Classname:    CountryCacheEJB.java
* Author:       Héctor Hernández Chávez
* Date:         18-jun-2019
*/
package javaee.examples.ejb.cache.entities.singleton;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.stream.Collectors;
import javaee.examples.ejb.cache.entities.Country;
import javax.annotation.PostConstruct;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Héctor Hernández Chávez
 */
@Singleton
@Startup
public class CountryCacheEJB {

    protected Queue<Country> cache = null;
    
    @PersistenceContext(name = "ejbExamplesPU")
    private EntityManager entityManager;
    
    public CountryCacheEJB() {
    }
    
    @PostConstruct
    protected void init() {
        cache = new ConcurrentLinkedDeque<>();
        loadCache();
    }
    
    @Lock(LockType.READ)
    public List<Country> get() {
        return cache.stream().collect(Collectors.toList());
    }
    
    protected void loadCache() {
        List<Country> list = entityManager.createNamedQuery(Country.FIND_ALL)
                .getResultList();
        list.forEach(cache::add);
    }
}
