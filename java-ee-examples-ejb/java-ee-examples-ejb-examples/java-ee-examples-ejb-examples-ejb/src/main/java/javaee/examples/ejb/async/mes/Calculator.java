/*
* Classname:    Calculator.java
* Author:       Héctor Hernández Chávez
* Date:         17-jul-2019
*/
package javaee.examples.ejb.async.mes;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.enterprise.concurrent.ManagedExecutorService;

/**
 * @author Héctor Hernández Chávez
 */
@Stateless
public class Calculator {

    @Resource
    ManagedExecutorService mes;
    
    public CompletableFuture<String> calculateSomething() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("1 " + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException ie) {
                System.out.println("20 InterruptedException " + ie.getMessage());
            }
            return "supplyAsync";
        }, mes)/*.thenApply((s) -> {
            System.out.println("2 " + Thread.currentThread().getName() + " " + s) ;
            return "thenApply";
        })*/;
    }
}
