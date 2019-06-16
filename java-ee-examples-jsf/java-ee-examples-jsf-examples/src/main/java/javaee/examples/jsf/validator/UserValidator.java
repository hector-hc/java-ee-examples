
/**
 * @Class UserValidator
 * @author Hector
 * @Created on Jun 16, 2019, 2:22:56 PM
 */

package javaee.examples.jsf.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("userValidator")
public class UserValidator implements Validator<User> {

    @Override
    public void validate(FacesContext context, UIComponent component, User value) throws ValidatorException {
        if (!value.getEmail().contains("@")) {
            throw new ValidatorException(new FacesMessage(null, "Malformed e-mail"));
        }
    }

}
