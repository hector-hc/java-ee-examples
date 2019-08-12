/*
* Classname:    FileHandler.java
* Author:       Héctor Hernández Chávez
* Date:         12-ago-2019
* © Concepto Móvil S.A. de C.V. 2014
*/
package javaee.examples.cdi.events.reactive;

import java.io.IOException;

/**
 * @author Héctor Hernández Chávez
 */
public interface FileHandler {
    void handle(FileEvent file) throws IOException;
}
