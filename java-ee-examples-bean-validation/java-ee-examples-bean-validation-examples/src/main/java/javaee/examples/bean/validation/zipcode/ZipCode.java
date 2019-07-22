/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaee.examples.bean.validation.zipcode;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author Hector
 */
@Retention(RUNTIME)
@Documented
@Target({METHOD, FIELD, PARAMETER, TYPE, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR})
@Constraint(validatedBy = {ZipCodeValidator.class})
@Size(min = 5)
//@ReportAsSingleViolation
@Pattern(regexp = "[0-9]*")
@NotNull(message = "{org.sample.zipcode.cannot_be_null}")
public @interface ZipCode {
    
    String message() default "{org.sample.zipcode.invalid_zipcode}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
    
    Country country() default Country.US;
    
    String parameter() default "";
    
    public enum Country {
        US,
        CANADA,
        MEXICO,
        INDIA
    }
}
