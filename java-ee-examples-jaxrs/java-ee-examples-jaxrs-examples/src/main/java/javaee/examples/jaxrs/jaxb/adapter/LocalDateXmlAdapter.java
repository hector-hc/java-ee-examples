/*
* Classname:    LocalDateXmlAdapter.java
* Author:       Héctor Hernández Chávez
* Date:         22-jul-2019
*/
package javaee.examples.jaxrs.jaxb.adapter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * @author Héctor Hernández Chávez
 */
public class LocalDateXmlAdapter extends XmlAdapter<String, LocalDate> {

    @Override
    public LocalDate unmarshal(String value) throws Exception {
        return Optional.ofNullable(value).map(v -> LocalDate.parse(v, DateTimeFormatter.ISO_DATE)).orElse(null);
    }

    @Override
    public String marshal(LocalDate date) throws Exception {
        return Optional.ofNullable(date).map(dt -> date.format(DateTimeFormatter.ISO_DATE)).orElse(null);
    }

}
