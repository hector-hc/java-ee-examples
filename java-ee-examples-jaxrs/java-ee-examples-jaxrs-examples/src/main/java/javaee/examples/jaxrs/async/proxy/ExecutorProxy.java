
/**
 * @Class ExecutorProxy
 * @author Hector
 * @Created on Jun 29, 2019, 9:59:09 AM
 */

package javaee.examples.jaxrs.async.proxy;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.enterprise.concurrent.ContextService;
import javax.enterprise.concurrent.ManagedThreadFactory;
import javax.inject.Singleton;

@Singleton
public class ExecutorProxy {

    @Resource
    ManagedThreadFactory factory;
    
    @Resource
    ContextService context;
    
    private ExecutorService executor;
    
    @PostConstruct
    public void init() {
        executor = new ThreadPoolExecutor(1, 5, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5), factory);
    }
    
    public Future<UserAsyncProxy> submit(Callable<UserAsyncProxy> task) {
        Callable<UserAsyncProxy> ctxProxy = context.createContextualProxy(task, Callable.class);
        return executor.submit(ctxProxy);
    }
}
