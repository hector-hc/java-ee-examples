/*
* Classname:    EntityManagerExposer.java
* Author:       Héctor Hernández Chávez
* Date:         17-jul-2019
*/
package javaee.examples.jpa.producers;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Héctor Hernández Chávez
 */
public class EntityManagerExposer {

    @Produces
    @JavaEEDB
    @PersistenceContext(unitName = "ejbExamplesPU")
    private EntityManager javaeeEntityManager;
}
