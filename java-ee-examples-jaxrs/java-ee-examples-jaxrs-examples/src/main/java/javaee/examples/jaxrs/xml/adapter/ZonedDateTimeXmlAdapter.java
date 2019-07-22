
/**
 * @Class ZonedDateTimeXmlAdapter
 * @author Hector
 * @Created on Jul 21, 2019, 8:36:03 PM
 */

package javaee.examples.jaxrs.xml.adapter;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class ZonedDateTimeXmlAdapter extends XmlAdapter<String, ZonedDateTime> {

    @Override
    public ZonedDateTime unmarshal(String value) throws Exception {
        return Optional.ofNullable(value).map(v -> ZonedDateTime.parse(v, DateTimeFormatter.ISO_DATE_TIME).withFixedOffsetZone()).orElse(null);
    }

    @Override
    public String marshal(ZonedDateTime v) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
