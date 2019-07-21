
/**
 * @Class SimpleGreetingInstanceQualifier
 * @author Hector
 * @Created on Jul 21, 2019, 1:53:30 PM
 */

package javaee.examples.cdi.instance.qualifiers;

import javax.enterprise.inject.Default;

@Personal
@Default
public class SimpleGreetingInstanceQualifier implements GreetingInstanceQualifier {

    @Override
    public String greet(String name) {
        return "Hello " + name;
    }

}
