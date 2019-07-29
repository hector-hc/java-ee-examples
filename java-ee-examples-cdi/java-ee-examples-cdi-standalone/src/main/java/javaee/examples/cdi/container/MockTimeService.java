/*
* Classname:    MockTimeService.java
* Author:       Héctor Hernández Chávez
* Date:         29-jul-2019
*/
package javaee.examples.cdi.container;

import java.time.LocalDateTime;
import java.time.Month;

/**
 * @author Héctor Hernández Chávez
 */
public class MockTimeService implements TimeService {

    @Override
    public LocalDateTime now() {
        return LocalDateTime.of(2017, Month.SEPTEMBER, 4, 19, 0);
    }

}
