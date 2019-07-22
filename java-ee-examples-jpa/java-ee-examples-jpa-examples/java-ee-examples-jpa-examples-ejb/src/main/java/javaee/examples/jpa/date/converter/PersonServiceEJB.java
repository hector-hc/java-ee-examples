
/**
 * @Class PersonServiceEJB
 * @author Hector
 * @Created on Jul 21, 2019, 8:19:56 PM
 */

package javaee.examples.jpa.date.converter;

import java.util.Optional;
import javaee.examples.jpa.entities.Person;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PersonServiceEJB {
    @PersistenceContext
    private EntityManager em;
    
    public Optional<Person> getPersonById(Long id) {
        return Optional.ofNullable(em.find(Person.class, id));
    }
    
    public Long createPerson(Person person) {
        em.persist(person);
        return person.getId();
    }
}
