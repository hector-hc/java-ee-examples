/*
* Classname:    AsyncTaskStatus.java
* Author:       Héctor Hernández Chávez
* Date:         28-jun-2019
*/
package javaee.examples.jaxrs.async.status;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.concurrent.ManagedTask;
import javax.enterprise.concurrent.ManagedTaskListener;
import javax.enterprise.inject.spi.CDI;
/**
 * @author Héctor Hernández Chávez
 */
public class AsyncTaskStatus implements Callable<UserAsyncStatus>, ManagedTaskListener, ManagedTask {

    private final long instantiationMili = new Date().getTime();
    
    private static final Logger LOG = Logger.getLogger(AsyncTaskStatus.class.getName());
   
    
    //@Inject
    private UserAsyncStatusService userAsyncStatusService;
    
    @Override
    public UserAsyncStatus call() throws Exception {
        userAsyncStatusService = CDI.current().select(UserAsyncStatusService.class).get();
        return userAsyncStatusService.getUser();
    }

    @Override
    public void taskSubmitted(Future<?> future, ManagedExecutorService mes, Object o) {
        long mili = new Date().getTime();
        LOG.log(Level.INFO, "taskSubmitted: {0} - Miliseconds since instantiation: {1}", new Object[]{future, mili - instantiationMili});
    }

    @Override
    public void taskAborted(Future<?> future, ManagedExecutorService mes, Object o, Throwable thrwbl) {
        long mili = new Date().getTime();
        LOG.log(Level.INFO, "taskAborted: {0} - Miliseconds since instantiation: {1}", new Object[]{future, mili - instantiationMili});
    }

    @Override
    public void taskDone(Future<?> future, ManagedExecutorService mes, Object o, Throwable thrwbl) {
        long mili = new Date().getTime();
        LOG.log(Level.INFO, "taskDone: {0} - Miliseconds since instantiation: {1}", new Object[]{future, mili - instantiationMili});
    }

    @Override
    public void taskStarting(Future<?> future, ManagedExecutorService mes, Object o) {
        long mili = new Date().getTime();
        LOG.log(Level.INFO, "taskStarting: {0} - Miliseconds since instantiation: {1}", new Object[]{future, mili - instantiationMili});
    }

    @Override
    public ManagedTaskListener getManagedTaskListener() {
        return this;
    }

    @Override
    public Map<String, String> getExecutionProperties() {
        return new HashMap<>();
    }

}
