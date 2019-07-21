
/**
 * @Class BuilderOrder
 * @author Hector
 * @Created on Jul 21, 2019, 3:13:06 PM
 */

package javaee.examples.bean.validation.groups;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;
import org.slf4j.Logger;

public class BuilderOrder {
    @Inject
    Logger logger;
    
    public void builderOrderCreation(@ConvertGroup(from = Default.class, to = Creation.class) @Valid final Order order) {
        logger.info("::: order creation: {}", order);
    }
    
    public void builderOrderPayment(@ConvertGroup(from = Default.class, to = Payment.class) @Valid final Order order) {
        logger.info("::: order payment: {}", order);
    }
    
    public void builderOrderDelivery(@ConvertGroup(from = Default.class, to = Delivery.class) @Valid final Order order) {
        logger.info("::: order delivery: {}", order);
    }
}
