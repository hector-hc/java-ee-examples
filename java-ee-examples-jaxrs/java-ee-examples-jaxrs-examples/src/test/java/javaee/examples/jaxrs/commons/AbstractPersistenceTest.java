
/**
 * @Class AbstractPersistenceTest
 * @author Hector
 * @Created on Jun 24, 2019, 9:01:38 AM
 */

package javaee.examples.jaxrs.commons;

import java.sql.SQLException;
import java.util.Properties;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.junit.After;
import org.junit.Before;

public class AbstractPersistenceTest {

    protected EntityManager em;
    protected EntityTransaction tx;
    
    @Before
    public void initEntityManager() throws Exception {
        Properties pros = new Properties();
        pros.setProperty(PersistenceUnitProperties.ECLIPSELINK_PERSISTENCE_XML, "META-INF/persistence-alternative.xml");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(Constants.PERSISTENCE_UNIT_NAME, pros);
        em = emf.createEntityManager();
        tx = em.getTransaction();
    }

    @After
    public void closeEntityManager() throws SQLException {
        if (em != null) {
            em.close();
        }
    }
}
