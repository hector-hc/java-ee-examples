/*
* Classname:    FromEightToThirteenDigitsDecorator.java
* Author:       Héctor Hernández Chávez
* Date:         16-jul-2019
*/
package javaee.examples.cdi.decorator.numgen;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

/**
 * @author Héctor Hernández Chávez
 */
@Decorator
public class FromEightToThirteenDigitsDecorator implements NumberGenerator {

    @Inject
    @Delegate
    private NumberGenerator numberGenerator;
    
    @Override
    public String generateNumber() {
        String issn = numberGenerator.generateNumber();
        String isbn = "13-84356" + issn.substring(1);
        return isbn;
    }

}
