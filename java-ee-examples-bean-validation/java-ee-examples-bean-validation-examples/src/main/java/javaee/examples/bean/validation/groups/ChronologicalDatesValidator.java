
/**
 * @Class ChronologicalDatesValidator
 * @author Hector
 * @Created on Jul 21, 2019, 3:05:40 PM
 */

package javaee.examples.bean.validation.groups;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.slf4j.Logger;

@ChronologicalDates(groups = Delivery.class)
public class ChronologicalDatesValidator implements ConstraintValidator<ChronologicalDates, Order> {

    @Inject Logger logger;
    
    @Override
    public void initialize(ChronologicalDates constraintAnnotation) {
    }

    @Override
    public boolean isValid(Order order, ConstraintValidatorContext context) {
        logger.info("creation_date: {}", order.getCreationDate());
        logger.info("payment_date: {}", order.getPaymentDate());
        logger.info("delivery_date: {}", order.getDeliveryDate());
        return order.getCreationDate().isBefore(order.getPaymentDate())
                && order.getPaymentDate().isBefore(order.getDeliveryDate());
    }

}
