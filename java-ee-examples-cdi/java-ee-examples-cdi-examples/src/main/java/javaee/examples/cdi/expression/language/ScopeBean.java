
/**
 * @Class ScopeBean
 * @author Hector
 * @Created on Jul 21, 2019, 1:04:31 PM
 */

package javaee.examples.cdi.expression.language;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class ScopeBean {

    public String sayHello() {
        return "Helloe there!";
    }
}
