
/**
 * @Class WSBatchAuction
 * @author Hector
 * @Created on Jul 22, 2019, 8:56:17 PM
 */

package javaee.examples.batch.simple.auction.ws;

import java.util.Properties;
import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.batch.runtime.JobExecution;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("batch/auction")
public class WSBatchAuction {

    @GET
    public Response startJobAuction() {
        JobOperator jobOperator = BatchRuntime.getJobOperator();
        Properties properties = new Properties();
        long execID = jobOperator.start("auction-job", properties);
        JobExecution jobExec = jobOperator.getJobExecution(execID);
        String status = jobExec.getBatchStatus().toString();
        return Response.ok(status).build();
    }
}
