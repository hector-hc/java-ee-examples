
/**
 * @Class ZipCodeValidator
 * @author Hector
 * @Created on Jul 21, 2019, 7:33:48 PM
 */

package javaee.examples.bean.validation.zipcode;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.slf4j.Logger;

public class ZipCodeValidator implements ConstraintValidator<ZipCode, String> {
    
    @Inject
    Logger logger;

    List<String> zipcodes;

    @Override
    public void initialize(ZipCode constraintAnnotation) {
        logger.info("ZipCodeValidator.initialize");
        zipcodes = new ArrayList<>();
        switch (constraintAnnotation.country()) {
            case US:
                zipcodes.add("95054");
                zipcodes.add("95051");
                zipcodes.add("94043");
                break;
            case CANADA:
                zipcodes.add("C1A");
                zipcodes.add("M3A");
                zipcodes.add("T4H");
                break;
            case MEXICO:
                zipcodes.add("01020");
                zipcodes.add("08400");
                zipcodes.add("13270");
                break;
            case INDIA:
                zipcodes.add("110092");
                zipcodes.add("400053");
                zipcodes.add("700073");
                break;
        }
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return zipcodes.contains(value);
    }
}
