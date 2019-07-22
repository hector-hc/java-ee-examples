/*
* Classname:    LocalDateTimeXmlAdapter.java
* Author:       Héctor Hernández Chávez
* Date:         22-jul-2019
*/
package javaee.examples.jaxrs.jaxb.adapter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * @author Héctor Hernández Chávez
 */
public class LocalDateTimeXmlAdapter extends XmlAdapter<String, LocalDateTime> {

    @Override
    public LocalDateTime unmarshal(String value) throws Exception {
        return Optional.ofNullable(value).map(v -> LocalDateTime.parse(v, DateTimeFormatter.ISO_DATE_TIME)).orElse(null);
    }

    @Override
    public String marshal(LocalDateTime dateTime) throws Exception {
        return Optional.ofNullable(dateTime).map(dt -> dateTime.format(DateTimeFormatter.ISO_DATE_TIME)).orElse(null);
    }

}
