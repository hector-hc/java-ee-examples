
/**
 * @Class OperationServlet
 * @author Hector
 * @Created on Jun 23, 2019, 3:12:59 PM
 */

package javaee.examplessecurity.programmatic;

import java.io.IOException;
import javax.annotation.security.DeclareRoles;
import javax.inject.Inject;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.SecurityContext;
import javax.security.enterprise.authentication.mechanism.http.AuthenticationParameters;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.Password;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@DeclareRoles({Roles.ADMIN, Roles.USER})
@WebServlet(name = "OperationServlet", urlPatterns = {"/OperationServlet"})
public class OperationServlet extends HttpServlet {

    @Inject
    SecurityContext securityContext;
    
    @Inject
    UserBean userBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        Credential credential = new UsernamePasswordCredential(name, new Password(password));
        AuthenticationStatus status = securityContext.authenticate(request, response, 
                AuthenticationParameters.withParams().credential(credential));
        response.getWriter().write("Role \"admin\" access: " + request.isUserInRole(Roles.ADMIN) + "\n");
        response.getWriter().write("Role \"user\" access: " + request.isUserInRole(Roles.USER) + "\n");

        if (status.equals(AuthenticationStatus.SUCCESS)) {

            if (request.isUserInRole(Roles.ADMIN)) {
                userBean.adminOperation();
                response.getWriter().write("adminOperation executed: true\n");
            } else if (request.isUserInRole(Roles.USER)) {
                userBean.userOperation();
                response.getWriter().write("userOperation executed: true\n");
            }

            userBean.everyoneCanDo();
            response.getWriter().write("everyoneCanDo executed: true\n");

        } else {
            response.getWriter().write("Authentication failed\n");
        }
    }
    
    
}
