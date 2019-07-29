/*
* Classname:    TimeService.java
* Author:       Héctor Hernández Chávez
* Date:         29-jul-2019
* © Concepto Móvil S.A. de C.V. 2014
*/
package javaee.examples.cdi.container;

import java.time.LocalDateTime;

/**
 * @author Héctor Hernández Chávez
 */
public interface TimeService {
    LocalDateTime now();
}
