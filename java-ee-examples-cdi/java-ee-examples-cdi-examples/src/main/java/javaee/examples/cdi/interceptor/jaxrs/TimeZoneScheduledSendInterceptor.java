/*
* Classname:    TimeZoneScheduledSendInterceptor.java
* Author:       Héctor Hernández Chávez
* Date:         22-jul-2019
 */
package javaee.examples.cdi.interceptor.jaxrs;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Optional;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 * @author Héctor Hernández Chávez
 */
@Interceptor
@ScheduledSendInterceptor
public class TimeZoneScheduledSendInterceptor {

    private final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @AroundInvoke
    public Object filter(InvocationContext context) throws Exception {
        Object[] parameters = context.getParameters();
        if (parameters.length > 0) {
            Arrays.asList(parameters).stream().forEach(parameter -> {
                System.out.println("parameter_value: " + parameter);
            });
            for (int i = 0; i < parameters.length; i++) {
                if (parameters[i] instanceof RequestScheduledSend) {
                    try {
                        RequestScheduledSend request = (RequestScheduledSend) parameters[i];
                        if (request.getScheduleSend() != null && !request.getScheduleSend().equals("")
                                && request.getTimeZone() != null && !request.getTimeZone().equals("")) {
                            Optional<String> optZone = ZoneId.getAvailableZoneIds().stream().filter(z -> z.equals(request.getTimeZone())).findAny();
                            if (optZone.isPresent()) {
                                LocalDateTime localDateTimeScheduledSend = LocalDateTime
                                        .parse(request.getScheduleSend(), DATE_TIME_FORMATTER);
                                ZonedDateTime zonedDateTimecheduledSend = ZonedDateTime.of(localDateTimeScheduledSend,
                                        ZoneId.of(request.getTimeZone()));
                                System.out.println("zonedDateTimecheduledSend: "
                                        + zonedDateTimecheduledSend + ", zone: " + request.getTimeZone());
                                ZonedDateTime zdtLocal = zonedDateTimecheduledSend.withZoneSameInstant(ZoneId.of("America/Mexico_City"));
                                System.out.println("Zone Date Time Local: " + zdtLocal);
                                request.setScheduleSend(DATE_TIME_FORMATTER.format(zdtLocal));
                                parameters[i] = request;
                                context.setParameters(parameters);
                            }
                        }
                    } catch (Exception e) {
                        System.err.println("TimeZoneScheduledSendInterceptor.filter");
                    }
                }
            }
        }
        return context.proceed();
    }
}
