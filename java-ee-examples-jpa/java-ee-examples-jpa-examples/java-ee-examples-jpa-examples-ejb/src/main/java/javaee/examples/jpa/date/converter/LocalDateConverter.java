
/**
 * @Class LocalDateConverter
 * @author Hector
 * @Created on Jul 21, 2019, 8:14:01 PM
 */

package javaee.examples.jpa.date.converter;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import javax.persistence.AttributeConverter;

public class LocalDateConverter implements AttributeConverter<LocalDate, Timestamp> {

    @Override
    public Timestamp convertToDatabaseColumn(LocalDate attribute) {
        return Optional.ofNullable(attribute).map(localDate -> Timestamp.valueOf(localDate.atStartOfDay())).orElse(null);
    }

    @Override
    public LocalDate convertToEntityAttribute(Timestamp dbData) {
        return Optional.ofNullable(dbData).map(Timestamp::toLocalDateTime).map(LocalDateTime::toLocalDate).orElse(null);
    }

}
