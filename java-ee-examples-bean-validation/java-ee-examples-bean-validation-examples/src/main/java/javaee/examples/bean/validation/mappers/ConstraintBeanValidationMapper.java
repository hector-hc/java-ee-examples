
/**
 * @Class ConstraintBeanValidationMapper
 * @author Hector
 * @Created on Jul 21, 2019, 4:31:22 PM
 */

package javaee.examples.bean.validation.mappers;

import java.util.stream.Collectors;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ConstraintBeanValidationMapper implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(ConstraintViolationException exception) {
        String message = exception.getConstraintViolations().stream()
                .map(c -> c.getMessage()).collect(Collectors.joining("|"));
        return Response.status(Response.Status.BAD_REQUEST).entity(message).build();
    }

}
