/*
* Classname:    UserBean.java
* Author:       Héctor Hernández Chávez <hector.hernandez@conceptomovil.com>
* Date:         17-jun-2019
* © Concepto Móvil S.A. de C.V. 2014
*/
package javaee.examples.batch.simple.beans;

import java.util.Properties;
import javax.batch.operations.JobOperator;
import javax.batch.operations.JobStartException;
import javax.batch.runtime.BatchRuntime;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * @author Héctor Hernández Chávez <hector.hernandez@conceptomovil.com>
 */
@Named
@RequestScoped
public class UserBean {

    public void run() {
        try {
            JobOperator job = BatchRuntime.getJobOperator();
            long jobId = job.start("acess-user", new Properties());
            System.out.println("Job Started: " + jobId);
        } catch (JobStartException e) {
        }
    }
}
