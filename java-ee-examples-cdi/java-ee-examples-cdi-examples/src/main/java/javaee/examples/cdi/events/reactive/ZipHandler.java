/*
* Classname:    ZipHandler.java
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
public class ZipHandler implements FileHandler {

    @Override
    public void handle(@ObservesAsync @Zip FileEvent file) throws IOException {
        FileSystemUtils.save(file.getFile(), "zip", "zip_" + new Date().getTime() + ".zip");
    }

}
