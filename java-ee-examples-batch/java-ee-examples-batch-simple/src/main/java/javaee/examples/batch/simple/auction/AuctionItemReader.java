
/**
 * @Class AuctionItemReader
 * @author Hector
 * @Created on Jul 22, 2019, 8:49:37 PM
 */

package javaee.examples.batch.simple.auction;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import javax.batch.api.chunk.AbstractItemReader;
import javax.inject.Named;

@Named
public class AuctionItemReader extends AbstractItemReader {
    
    private BufferedReader bufferedReader;
    
    @Override
    public void open(final Serializable ckpt) throws Exception {
        bufferedReader = new BufferedReader(new InputStreamReader(Thread
                .currentThread().getContextClassLoader().getResourceAsStream("/META-INF/auctions.csv")));
    }
    
    @Override
    public Object readItem() throws Exception {
        System.out.println("AuctionItemReader.readItem");
        return bufferedReader.readLine();
    }
}
