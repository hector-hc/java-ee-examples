/*
* Classname:    DomainEvent.java
* Author:       Héctor Hernández Chávez
* Date:         16-jul-2019
*/
package javaee.examples.jaxrs.sse.broadcaster.simple;

/**
 * @author Héctor Hernández Chávez
 */
public class DomainEvent {

    private final String contents;
    
    public DomainEvent(String contents) {
        this.contents = contents;
    }
    
    public String getContents() {
        return this.contents;
    }
}
