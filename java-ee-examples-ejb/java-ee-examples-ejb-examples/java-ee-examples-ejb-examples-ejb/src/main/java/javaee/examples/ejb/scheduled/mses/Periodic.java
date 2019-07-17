/*
* Classname:    Periodic.java
* Author:       Héctor Hernández Chávez
* Date:         17-jul-2019
*/
package javaee.examples.ejb.scheduled.mses;

import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedScheduledExecutorService;
import javax.enterprise.context.ApplicationScoped;

/**
 * @author Héctor Hernández Chávez
 */
@ApplicationScoped
public class Periodic {

    @Resource
    ManagedScheduledExecutorService mses;
    
    public void startasyncJobs() {
        mses.schedule(this::execute, 1, TimeUnit.SECONDS);
        mses.scheduleAtFixedRate(this::execute, 6, 1, TimeUnit.SECONDS);
    }
    
    private void execute() {
        System.out.println("Periodic.execute " + Thread.currentThread().getName());
    }
}
