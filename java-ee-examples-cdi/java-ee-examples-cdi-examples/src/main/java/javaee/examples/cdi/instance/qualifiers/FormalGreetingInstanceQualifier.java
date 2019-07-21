
/**
 * @Class FormalGreetingInstanceQualifier
 * @author Hector
 * @Created on Jul 21, 2019, 1:54:23 PM
 */

package javaee.examples.cdi.instance.qualifiers;

@Business
public class FormalGreetingInstanceQualifier implements GreetingInstanceQualifier {

    @Override
    public String greet(String name) {
        return "Good morning " + name;
    }

}
