/*
* Classname:    RequestScheduledSend.java
* Author:       Héctor Hernández Chávez
* Date:         22-jul-2019
*/
package javaee.examples.cdi.interceptor.jaxrs;

import java.io.Serializable;

/**
 * @author Héctor Hernández Chávez
 */
public class RequestScheduledSend implements Serializable {

    private String compaignName;
    
    private String scheduleSend;
    
    private String timeZone;

    public String getCompaignName() {
        return compaignName;
    }

    public void setCompaignName(String compaignName) {
        this.compaignName = compaignName;
    }

    public String getScheduleSend() {
        return scheduleSend;
    }

    public void setScheduleSend(String scheduleSend) {
        this.scheduleSend = scheduleSend;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }
    
}
