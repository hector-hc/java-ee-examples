/*
* Classname:    ValidUserValidator.java
* Author:       Héctor Hernández Chávez
* Date:         16-jul-2019
*/
package javaee.examples.jaxrs.bean.validation.json;

import javax.json.JsonObject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Héctor Hernández Chávez
 */
public class ValidUserValidator implements ConstraintValidator<ValidUser, JsonObject> {

    @Override
    public void initialize(ValidUser a) {
    }

    @Override
    public boolean isValid(JsonObject t, ConstraintValidatorContext cvc) {
        return t.getString("name", null) != null;
    }

}
