
/**
 * @Class AsyncTaskProxy
 * @author Hector
 * @Created on Jun 29, 2019, 9:53:03 AM
 */

package javaee.examples.jaxrs.async.proxy;

import java.util.concurrent.Callable;
import javax.enterprise.inject.spi.CDI;

public class AsyncTaskProxy implements Callable<UserAsyncProxy> {

    private final UserAsyncProxyService asyncService = CDI.current().select(UserAsyncProxyService.class).get();
    
    @Override
    public UserAsyncProxy call() throws Exception {
        return asyncService.getUser();
    }

}
