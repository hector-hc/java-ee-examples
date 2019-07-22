
/**
 * @Class LocalDateTimeConverter
 * @author Hector
 * @Created on Jul 21, 2019, 8:11:22 PM
 */

package javaee.examples.jpa.date.converter;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, Timestamp> {

    @Override
    public Timestamp convertToDatabaseColumn(LocalDateTime attribute) {
        return Optional.ofNullable(attribute).map(Timestamp::valueOf).orElse(null);
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Timestamp dbData) {
        return Optional.ofNullable(dbData).map(Timestamp::toLocalDateTime).orElse(null);
    }

}
