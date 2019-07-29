
/**
 * @Class MyEvent
 * @author Hector
 * @Created on Jun 14, 2019, 1:30:43 PM
 */

package javaee.examples.cdi.standalone;

public class MyEvent {
    private final String value;
    
    public MyEvent(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    
}
