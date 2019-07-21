
/**
 * @Class IntValueController
 * @author Hector
 * @Created on Jul 21, 2019, 2:23:06 PM
 */

package javaee.examples.cdi.producers.primitves;

import java.io.Serializable;
import javax.enterprise.inject.Produces;

public class IntValueController implements Serializable {

    @Produces @IntValue
    public int initialValue = 1000;
}
