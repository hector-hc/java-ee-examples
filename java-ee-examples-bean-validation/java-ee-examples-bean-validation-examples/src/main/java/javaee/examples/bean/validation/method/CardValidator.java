
/**
 * @Class CardValidator
 * @author Hector
 * @Created on Jul 21, 2019, 7:19:41 PM
 */

package javaee.examples.bean.validation.method;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;

public class CardValidator {

    @NotNull
    @AssertTrue
    public Boolean isValid(String number) {
        return null;
    }
}
