
/**
 * @Class AuctionItemWriter
 * @author Hector
 * @Created on Jul 22, 2019, 8:54:49 PM
 */

package javaee.examples.batch.simple.auction;

import java.util.List;
import javaee.examples.batch.simple.entities.Auction;
import javax.batch.api.chunk.AbstractItemWriter;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Named
public class AuctionItemWriter extends AbstractItemWriter {

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public void writeItems(List<Object> items) throws Exception {
        items.stream().map(Auction.class::cast).forEach(em::persist);
    }
}
