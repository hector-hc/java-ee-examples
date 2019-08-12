/*
* Classname:    PdfHandler.java
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
public class PdfHandler implements FileHandler {
    @Override
    public void handle(@ObservesAsync @Pdf FileEvent file) throws IOException {
        FileSystemUtils.save(file.getFile(), "pdf", "pdf_" + new Date().getTime() + ".pdf");
    }
}
