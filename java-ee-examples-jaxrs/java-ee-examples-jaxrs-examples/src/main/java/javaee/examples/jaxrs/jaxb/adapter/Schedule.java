/*
* Classname:    Schedule.java
* Author:       Héctor Hernández Chávez
* Date:         22-jul-2019
*/
package javaee.examples.jaxrs.jaxb.adapter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * @author Héctor Hernández Chávez
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Schedule {
    
    @XmlJavaTypeAdapter(LocalDateXmlAdapter.class)
    private LocalDate shiftStartDate;
    
    @XmlJavaTypeAdapter(LocalDateXmlAdapter.class)
    private LocalDate shiftEndDate;
    
    @XmlJavaTypeAdapter(LocalDateTimeXmlAdapter.class)
    private LocalDateTime shiftStartTime;
    
    @XmlJavaTypeAdapter(LocalDateTimeXmlAdapter.class)
    private LocalDateTime shiftEndTime;
    
    public Schedule() {
    }

    public Schedule(LocalDate shiftStartDate, LocalDate shiftEndDate, LocalDateTime shiftStartTime, LocalDateTime shiftEndTime) {
        this.shiftStartDate = shiftStartDate;
        this.shiftEndDate = shiftEndDate;
        this.shiftStartTime = shiftStartTime;
        this.shiftEndTime = shiftEndTime;
    }

    public LocalDate getShiftStartDate() {
        return shiftStartDate;
    }

    public void setShiftStartDate(LocalDate shiftStartDate) {
        this.shiftStartDate = shiftStartDate;
    }

    public LocalDate getShiftEndDate() {
        return shiftEndDate;
    }

    public void setShiftEndDate(LocalDate shiftEndDate) {
        this.shiftEndDate = shiftEndDate;
    }

    public LocalDateTime getShiftStartTime() {
        return shiftStartTime;
    }

    public void setShiftStartTime(LocalDateTime shiftStartTime) {
        this.shiftStartTime = shiftStartTime;
    }

    public LocalDateTime getShiftEndTime() {
        return shiftEndTime;
    }

    public void setShiftEndTime(LocalDateTime shiftEndTime) {
        this.shiftEndTime = shiftEndTime;
    }
    
}
