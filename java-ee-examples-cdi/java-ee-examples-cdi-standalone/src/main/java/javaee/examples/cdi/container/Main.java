/*
* Classname:    Main.java
* Author:       Héctor Hernández Chávez
* Date:         29-jul-2019
*/
package javaee.examples.cdi.container;

/**
 * @author Héctor Hernández Chávez
 */
public class Main {

    public static void main(String[] args) {
        final Container container = new Container();
        container.register(TimeService.class, TimeServiceImpl.class);
        final TimeService timeService = container.get(TimeService.class);
        System.out.println("" + timeService.now());
    }
}
