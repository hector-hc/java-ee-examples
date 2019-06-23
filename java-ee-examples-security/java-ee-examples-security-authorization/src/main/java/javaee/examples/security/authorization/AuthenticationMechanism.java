
/**
 * @Class AuthenticationMechanism
 * @author Hector
 * @Created on Jun 23, 2019, 9:11:07 AM
 */

package javaee.examples.security.authorization;

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
    public AuthenticationStatus validateRequest(final HttpServletRequest request, 
            final HttpServletResponse response, HttpMessageContext httpMessageContext) throws AuthenticationException {
        if (httpMessageContext.isAuthenticationRequest()) {
            Credential credential = httpMessageContext.getAuthParameters().getCredential();
            if (!(credential instanceof CallerOnlyCredential)) {
                throw new IllegalStateException("Invalid mechanism");
            }
            
            CallerOnlyCredential callerOnlyCredential = (CallerOnlyCredential) credential;
            
            if (null == callerOnlyCredential.getCaller()) {
                throw new AuthenticationException();
            } else {
                switch (callerOnlyCredential.getCaller()) {
                    case "user1":
                        return httpMessageContext.notifyContainerAboutLogin(callerOnlyCredential.getCaller(), new HashSet<>(Arrays.asList(Roles.ROLE1)));
                    case "user2":
                        return httpMessageContext.notifyContainerAboutLogin(callerOnlyCredential.getCaller(), new HashSet<>(Arrays.asList(Roles.ROLE2)));
                    case "user3":
                        return httpMessageContext.notifyContainerAboutLogin(callerOnlyCredential.getCaller(), new HashSet<>(Arrays.asList(Roles.ROLE3)));
                        default:
                            throw new AuthenticationException();
                }
            }
        }
        return httpMessageContext.doNothing();
    }

}
