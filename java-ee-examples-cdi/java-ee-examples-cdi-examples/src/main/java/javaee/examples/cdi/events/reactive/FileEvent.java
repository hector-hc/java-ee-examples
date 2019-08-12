/*
* Classname:    FileEvent.java
* Author:       Héctor Hernández Chávez
* Date:         12-ago-2019
*/
package javaee.examples.cdi.events.reactive;

import java.io.File;

/**
 * @author Héctor Hernández Chávez
 */
public class FileEvent {
    private File file;
    private String mimeType;
    
    public FileEvent() {
    }

    public FileEvent(File file, String mimeType) {
        this.file = file;
        this.mimeType = mimeType;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }
    
}
