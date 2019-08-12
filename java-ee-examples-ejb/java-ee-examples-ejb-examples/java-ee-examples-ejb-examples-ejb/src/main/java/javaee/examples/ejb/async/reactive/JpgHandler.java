/*
* Classname:    JpgHandler.java
* Author:       Héctor Hernández Chávez
* Date:         12-ago-2019
*/
package javaee.examples.ejb.async.reactive;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.Future;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;

/**
 * @author Héctor Hernández Chávez
 */
@Stateless
public class JpgHandler {

    @Asynchronous
    public Future<String> handler(FileBean file) throws IOException {
        return new AsyncResult(FileSystemUtils.save(file.getFile(), "jpg", "jpg_" + new Date().getTime() + ".jpg"));
    }
    
    public String handlerCs(FileBean file) throws IOException {
        return FileSystemUtils.save(file.getFile(), "jpg", "jpg_" + new Date().getTime() + ".jpg");
    }
}
