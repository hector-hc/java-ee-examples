/*
* Classname:    UserReader.java
* Author:       Héctor Hernández Chávez
* Date:         17-jun-2019
*/
package javaee.examples.batch.simple.items;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import javax.batch.api.chunk.AbstractItemReader;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

/**
 * @author Héctor Hernández Chávez
 */
@Named
@Dependent
public class UserReader extends AbstractItemReader {

    private BufferedReader br;
    
    @Override
    public void open(Serializable checkpoint) throws Exception {
        br = new BufferedReader(new InputStreamReader(Thread.currentThread()
                .getContextClassLoader().getResourceAsStream("META-INF/user.txt")));
    }
    
    @Override
    public Object readItem() throws Exception {
        String line = null;
        try {
            line = br.readLine();
        } catch (IOException ioe) {
            System.out.println("error " + ioe.getMessage());
        }
        return line;
    }

    @Override
    public void close() throws IOException {
        if (br != null) {
            br.close();
        }
    }
}
