/*
* Classname:    JpgHandler.java
* Author:       Héctor Hernández Chávez
* Date:         12-ago-2019
*/
package javaee.examples.cdi.events.reactive;

import java.io.IOException;
import java.util.Date;
import javax.enterprise.event.ObservesAsync;

/**
 * @author Héctor Hernández Chávez
 */
public class JpgHandler implements FileHandler {

    @Override
    public void handle(@ObservesAsync @Jpg FileEvent file) throws IOException {
        FileSystemUtils.save(file.getFile(), "jpg", "jpg_" + new Date().getTime() + ".jpg");
    }

}
