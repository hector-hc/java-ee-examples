/**
 * @Class AuctionItemProcessor
 * @author Hector
 * @Created on Jul 22, 2019, 8:53:37 PM
 */
package javaee.examples.batch.simple.auction;

import java.util.Optional;
import javaee.examples.batch.simple.entities.Auction;
import javax.batch.api.chunk.ItemProcessor;
import javax.inject.Named;

@Named
public class AuctionItemProcessor implements ItemProcessor {

    @Override
    public Object processItem(Object item) throws Exception {
        return Optional.of(item).map(String.class::cast).map(s -> s.split(",")).
                map(a -> new Auction(null, a[1],
                Long.valueOf(a[2]),
                Long.valueOf(a[3]),
                Integer.valueOf(a[4]))).get();
    }
}
