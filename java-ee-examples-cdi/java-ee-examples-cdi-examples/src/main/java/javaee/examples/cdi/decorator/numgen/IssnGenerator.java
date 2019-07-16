/*
* Classname:    IssnGenerator.java
* Author:       Héctor Hernández Chávez
* Date:         16-jul-2019
*/
package javaee.examples.cdi.decorator.numgen;

import java.util.Random;

/**
 * @author Héctor Hernández Chávez
 */
public class IssnGenerator implements NumberGenerator {

    @Override
    public String generateNumber() {
        return "8-" + Math.abs(new Random().nextInt());
    }

}
