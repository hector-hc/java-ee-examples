
/**
 * @Class Authenticator
 * @author Hector
 * @Created on Jun 23, 2019, 7:55:25 AM
 */

package javaee.examples.secutiry.realm.jdbc;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.xml.bind.DatatypeConverter;

public class Authenticator implements ClientRequestFilter {

    private final String user;
    private final String password;
    
    public Authenticator(final String user, final String password) {
        this.user = user;
        this.password = password;
    }
    
    @Override
    public void filter(ClientRequestContext requestContext) throws IOException {
        MultivaluedMap<String, Object> headers = requestContext.getHeaders();
        final String basicAuthentication = getBasicAuthenticator();
        headers.add("Authorization", basicAuthentication);
    }

    private String getBasicAuthenticator() {
        String token = this.user + ":" + this.password;
        try {
            return "BASIC " + DatatypeConverter.printBase64Binary(token.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException use) {
            throw new IllegalStateException("Cannot encode with UTF-8");
        }
    }
}
