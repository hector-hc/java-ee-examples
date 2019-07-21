
/**
 * @Class HttpServletRequestDecorator
 * @author Hector
 * @Created on Jul 20, 2019, 9:42:13 PM
 */

package javaee.examples.cdi.decorator.builtin;

import java.io.Serializable;
import javax.annotation.Priority;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

@Decorator
@Priority(100)
public abstract class HttpServletRequestDecorator implements HttpServletRequest, Serializable {

    @Inject
    @Delegate
    private HttpServletRequest request;
    
    @Override
    public String getParameter(String name) {
        System.out.println("HttpServletRequestDecorator.getParameter");
        if ("decorate".equals(name)) {
            return "true";
        }
        return request.getParameter(name);
    }
}
