
/**
 * @Class AuthenticationMechanism
 * @author Hector
 * @Created on Jun 23, 2019, 3:09:03 PM
 */

package javaee.examplessecurity.programmatic;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.security.enterprise.AuthenticationException;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.authentication.mechanism.http.HttpAuthenticationMechanism;
import javax.security.enterprise.authentication.mechanism.http.HttpMessageContext;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ApplicationScoped
public class AuthenticationMechanism implements HttpAuthenticationMechanism {

    @Inject
    UserIdentityStore identityStore;
    
    @Override
    public AuthenticationStatus validateRequest(HttpServletRequest request, 
            HttpServletResponse response, HttpMessageContext httpMessageContext) throws AuthenticationException {
        
        if (httpMessageContext.isAuthenticationRequest()) {
            Credential credential = httpMessageContext.getAuthParameters().getCredential();
            if (!(credential instanceof UsernamePasswordCredential)) {
                throw new IllegalArgumentException("Invalid mechanism");
            }
            return httpMessageContext.notifyContainerAboutLogin(identityStore.validate(credential));
        }
        return httpMessageContext.doNothing();
    }

}
