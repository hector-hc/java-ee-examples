/*
* Classname:    UserReader.java
* Author:       Héctor Hernández Chávez
* Date:         17-jun-2019
*/
package javaee.examples.batch.simple.items;

import java.util.List;
import javaee.examples.batch.simple.entities.User;
import javax.batch.api.chunk.AbstractItemWriter;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
/**
 * @author Héctor Hernández Chávez
 */
@Named
@Dependent
public class UserWriter extends AbstractItemWriter {

    @PersistenceContext
    EntityManager entityManager;
    
    @Override
    @Transactional
    public void writeItems(List<Object> items) throws Exception {
        items.stream().map(User.class::cast).forEach(entityManager::persist);
    }

}
