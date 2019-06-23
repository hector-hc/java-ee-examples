
/**
 * @Class BaseBacking
 * @author Hector
 * @Created on Jun 22, 2019, 8:53:26 PM
 */

package javaee.examples.jsf.backing;

import java.io.Serializable;
import java.util.Map;
import java.util.ResourceBundle;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class BaseBacking implements Serializable {
    
    protected FacesContext getContext() {
        return FacesContext.getCurrentInstance();
    }
    
    protected Map getRequestMap() {
        return getContext().getExternalContext().getRequestMap();
    }
    
    protected HttpServletRequest getRequest() {
        return (HttpServletRequest) getContext().getExternalContext().getRequest();
    }
    
    protected HttpSession getSession() {
        return (HttpSession) getContext().getExternalContext().getSession(false);
    }
    
    protected Object evaluateEL(final String elExpression, final Class beanClazz) {
        return getContext().getApplication().evaluateExpressionGet(getContext(), elExpression, beanClazz);
    }
    
    protected ResourceBundle getResourceBundle() {
        return getContext().getApplication().getResourceBundle(getContext(), "msg");
    }
}
