/*
* Classname:    UserProcessor.java
* Author:       Héctor Hernández Chávez
* Date:         17-jun-2019
*/

package javaee.examples.batch.simple.items;

import java.util.StringTokenizer;
import javaee.examples.batch.simple.entities.User;
import javax.batch.api.chunk.ItemProcessor;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

/**
 * @author Héctor Hernández Chávez
 */
@Named
@Dependent
public class UserProcessor implements ItemProcessor {

    @Override
    public Object processItem(Object item) throws Exception {
        User user = new User();
        StringTokenizer tokens = new StringTokenizer((String) item, ",");
        user.setName(tokens.nextToken());
        user.setEmail(tokens.nextToken());
        return user;
    }

}
