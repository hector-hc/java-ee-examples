
/**
 * @Class AsyncTaskScheduled
 * @author Hector
 * @Created on Jun 29, 2019, 9:27:02 AM
 */

package javaee.examples.jaxrs.async.scheduled;

import java.util.concurrent.Callable;
import javax.enterprise.inject.spi.CDI;

public class AsyncTaskScheduled implements Callable<UserAsyncScheduled> {

    private final UserAsyncScheduledService userAsyncService = CDI.current()
            .select(UserAsyncScheduledService.class).get();
    
    @Override
    public UserAsyncScheduled call() throws Exception {
        return userAsyncService.getUser();
    }

}
