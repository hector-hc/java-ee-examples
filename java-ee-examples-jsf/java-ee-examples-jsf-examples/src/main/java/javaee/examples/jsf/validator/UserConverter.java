
/**
 * @Class UserConverter
 * @author Hector
 * @Created on Jun 16, 2019, 2:18:24 PM
 */

package javaee.examples.jsf.validator;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("userConverter")
public class UserConverter implements Converter<User> {

    @Override
    public User getAsObject(FacesContext context, UIComponent component, String value) {
        return new User(value.substring(0, value.indexOf("|")), value.substring(value.indexOf("|") + 1));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, User value) {
        return value.getName() + "|" + value.getEmail();
    }

}
