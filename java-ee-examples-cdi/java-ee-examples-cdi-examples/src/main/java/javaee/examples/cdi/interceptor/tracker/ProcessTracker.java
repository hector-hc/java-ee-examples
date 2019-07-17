/*
* Classname:    ProcessTracker.java
* Author:       Héctor Hernández Chávez
* Date:         17-jul-2019
*/
package javaee.examples.cdi.interceptor.tracker;

/**
 * @author Héctor Hernández Chávez
 */
public class ProcessTracker {

    public void track(Category category) {
        System.out.println("tracking: " + category);
    }
    
}
