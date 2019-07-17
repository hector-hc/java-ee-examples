/*
* Classname:    ReportFutureBuilder.java
* Author:       Héctor Hernández Chávez
* Date:         17-jul-2019
*/
package javaee.examples.ejb.async.future;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;

/**
 * @author Héctor Hernández Chávez
 */
@Stateless
public class ReportFutureBuilder {

    @Asynchronous
    public Future<String> buildReport() {
        System.out.println("ReportFutureBuilder.buildReport INIT");
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException ie) {
            System.err.println("ReportBuilder InterruptedException.....");
        }
        System.out.println("ReportFutureBuilder.buildReport FINISH");
        return new AsyncResult<>("OK");
    }
}
