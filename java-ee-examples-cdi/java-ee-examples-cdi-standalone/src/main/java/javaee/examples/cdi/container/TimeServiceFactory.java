/*
* Classname:    TimeServiceFactory.java
* Author:       Héctor Hernández Chávez
* Date:         29-jul-2019
*/
package javaee.examples.cdi.container;

/**
 * @author Héctor Hernández Chávez
 */
public class TimeServiceFactory {

    public static TimeService create() {
        if (useDefault()) {
            return new TimeServiceImpl();
        } else {
            return new MockTimeService();
        }
    }
    
    public static boolean useDefault() {
        return true;
    }
}
