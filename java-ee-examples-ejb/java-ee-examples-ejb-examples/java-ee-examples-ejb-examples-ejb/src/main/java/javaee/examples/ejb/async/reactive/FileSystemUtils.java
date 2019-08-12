/*
* Classname:    FileSystemUtils.java
* Author:       Héctor Hernández Chávez
* Date:         12-ago-2019
*/
package javaee.examples.ejb.async.reactive;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

/**
 * @author Héctor Hernández Chávez
 */
public class FileSystemUtils {

    public static String save(File file, String path, String fileName) throws IOException {
        File fileToSave = new File(System.getProperty("java.io.tmpdir") + "/" + path + "/" + fileName);
        try (InputStream input = new FileInputStream(file)) {
            Files.copy(input, fileToSave.toPath());
        }
        return fileToSave.getAbsolutePath();
    }
}
