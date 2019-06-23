
/**
 * @Class AuthenticationMechanism
 * @author Hector
 * @Created on Jun 23, 2019, 2:26:31 PM
 */

package javaee.examples.security.declarative;

import java.util.Arrays;
import java.util.HashSet;
import javax.enterprise.context.ApplicationScoped;
import javax.security.enterprise.AuthenticationException;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.authentication.mechanism.http.HttpAuthenticationMechanism;
import javax.security.enterprise.authentication.mechanism.http.HttpMessageContext;
import javax.security.enterprise.credential.CallerOnlyCredential;
import javax.security.enterprise.credential.Credential;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ApplicationScoped
public class AuthenticationMechanism implements HttpAuthenticationMechanism {

    @Override
    public AuthenticationStatus validateRequest(HttpServletRequest request, 
            HttpServletResponse response, HttpMessageContext httpMessageContext) 
            throws AuthenticationException {
        if (httpMessageContext.isAuthenticationRequest()) {
            Credential credential = httpMessageContext.getAuthParameters().getCredential();
            if (!(credential instanceof CallerOnlyCredential)) {
                throw new IllegalStateException("Invalid mechanism");
            }
            CallerOnlyCredential calleOnlyCredential = (CallerOnlyCredential) credential;
            if (null == calleOnlyCredential.getCaller()) {
                throw new AuthenticationException();
            } else {
                switch (calleOnlyCredential.getCaller()) {
                    case Roles.ADMIN:
                        return httpMessageContext.notifyContainerAboutLogin(calleOnlyCredential.getCaller(), new HashSet<>(Arrays.asList(Roles.ADMIN)));
                    case Roles.USER:
                        return httpMessageContext.notifyContainerAboutLogin(calleOnlyCredential.getCaller(), new HashSet<>(Arrays.asList(Roles.ADMIN)));
                    default:
                        throw new AuthenticationException();
                }
            }
        }
        return httpMessageContext.doNothing();
    }

}
