/*
* Classname:    UserNameNotTakenValidator.java
* Author:       Héctor Hernández Chávez
* Date:         16-jul-2019
*/
package javaee.examples.jaxrs.bean.validation;

import javax.enterprise.inject.spi.CDI;
import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Héctor Hernández Chávez
 */
public class UserNameNotTakenValidator implements ConstraintValidator<UserNameNotTaken, String> {

    //@Inject
    UserStore userStore;

    @Override
    public void initialize(UserNameNotTaken constraintAnnotation) {
        userStore = CDI.current().select(UserStore.class).get();
    }
    
    
    
    @Override
    public boolean isValid(String t, ConstraintValidatorContext cvc) {
        System.out.println("UserNameNotTakenValidator.isValid: " + t);
        return !userStore.isNamedTaken(t);
    }

}
