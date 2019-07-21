
/**
 * @Class LoggerProducer
 * @author Hector
 * @Created on Jul 21, 2019, 2:20:22 PM
 */

package javaee.examples.cdi.producers.logger;

import java.util.logging.Logger;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.ws.rs.Produces;

public class LoggerProducer {

    @Produces
    public Logger produceLogger(InjectionPoint injectionPoint) {
        return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
    }
}
