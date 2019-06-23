
/**
 * @Class UserLayoutBean
 * @author Hector
 * @Created on Jun 22, 2019, 8:46:31 PM
 */

package javaee.examples.jsf.layout;

import java.io.Serializable;
import java.util.Date;
import javaee.examples.jsf.backing.BaseBacking;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class UserLayoutBean extends BaseBacking implements Serializable {

    public Long getTimestamp() {
        return new Date().getTime();
    }
}
