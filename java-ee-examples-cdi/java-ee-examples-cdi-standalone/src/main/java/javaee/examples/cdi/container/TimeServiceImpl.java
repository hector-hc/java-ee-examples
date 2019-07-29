/*
* Classname:    TimeServiceImpl.java
* Author:       Héctor Hernández Chávez
* Date:         29-jul-2019
*/
package javaee.examples.cdi.container;

import java.time.LocalDateTime;

/**
 * @author Héctor Hernández Chávez
 */
public class TimeServiceImpl implements TimeService {

    @Override
    public LocalDateTime now() {
        return LocalDateTime.now();
    }

}
