
/**
 * @Class SimpleGreetingPkg
 * @author Hector
 * @Created on Jul 21, 2019, 2:42:22 PM
 */

package javaee.examples.cdi.vetoed.pkg;

import javaee.examples.cdi.vetoed.Greeting;

public class SimpleGreetingPkg implements Greeting {

    @Override
    public String greet(String name) {
        return "Hola " + name + "!!!!!";
    }

}
