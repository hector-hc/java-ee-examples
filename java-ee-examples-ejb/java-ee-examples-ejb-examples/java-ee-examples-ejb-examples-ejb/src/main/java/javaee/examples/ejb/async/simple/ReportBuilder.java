/*
* Classname:    ReportBuilder.java
* Author:       Héctor Hernández Chávez
* Date:         17-jul-2019
*/
package javaee.examples.ejb.async.simple;

import java.util.concurrent.TimeUnit;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;

/**
 * @author Héctor Hernández Chávez
 */
@Stateless
public class ReportBuilder {

    @Asynchronous
    public void buildReport() {
        System.out.println("ReportBuilder.buildReport INIT");
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException ie) {
            System.err.println("ReportBuilder InterruptedException.....");
        }
        System.out.println("ReportBuilder.buildReport FINISH");
    }
}
