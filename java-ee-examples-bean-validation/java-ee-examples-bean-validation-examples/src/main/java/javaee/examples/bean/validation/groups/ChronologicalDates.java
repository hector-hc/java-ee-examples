/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaee.examples.bean.validation.groups;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 *
 * @author Hector
 */
@Constraint(validatedBy = {ChronologicalDatesValidator.class})
@Retention(RUNTIME)
@Target({TYPE})
public @interface ChronologicalDates {
     String message() default "Dates have to be in chronological order";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
