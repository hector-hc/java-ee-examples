
/**
 * @Class ProducerLogger
 * @author Hector
 * @Created on Jul 21, 2019, 3:08:17 PM
 */

package javaee.examples.bean.validation.produces.logger;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProducerLogger {

    @Produces
    public Logger createLogger(InjectionPoint injectionPoint) {
        return LoggerFactory.getLogger(injectionPoint.getMember().getDeclaringClass());
    }
}
