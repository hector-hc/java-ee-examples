
/**
 * @Class UserServlet
 * @author Hector
 * @Created on Jun 23, 2019, 2:34:52 PM
 */

package javaee.examples.security.declarative;

import java.io.IOException;
import javax.annotation.security.DeclareRoles;
import javax.inject.Inject;
import javax.security.enterprise.SecurityContext;
import javax.security.enterprise.authentication.mechanism.http.AuthenticationParameters;
import javax.security.enterprise.credential.CallerOnlyCredential;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@DeclareRoles({Roles.ADMIN, Roles.USER})
@WebServlet(name = "UserServlet", urlPatterns = {"/UserServlet"})
public class UserServlet extends HttpServlet {

    @Inject
    SecurityContext securityContext;
    
    @Inject
    UserExecutor userExecutor;
    
    @Inject
    UserBean userBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        try {
            securityContext.authenticate(request, response, AuthenticationParameters
                    .withParams().credential(new CallerOnlyCredential(Roles.USER)));
            response.getWriter().write("Role \"admin\" access: " + request.isUserInRole(Roles.ADMIN) + "\n");
            response.getWriter().write("Role \"user\" access: " + request.isUserInRole(Roles.USER) + "\n");
            
            userExecutor.run(() -> {
                try {
                    userBean.adminOperation();
                    response.getWriter().write("adminOperation executed: true\n");
                } catch (Exception e) {
                    response.getWriter().write("adminOperation executed: false\n");
                }
                try {
                    userBean.userOperation();
                    response.getWriter().write("userOperation executed: true\n");
                } catch (Exception e) {
                    response.getWriter().write("userOperation executed: false\n");
                }
            });
            
            try {
                userBean.everyneCanDo();
                response.getWriter().write("everyoneCanDo executed: true\n");
            } catch (Exception e) {
                response.getWriter().write("everyoneCanDo executed: false\n");
            }

            try {
                userBean.noneCanDo();
                response.getWriter().write("noneCanDo executed: true\n");
            } catch (Exception e) {
                response.getWriter().write("noneCanDo executed: false\n");
            }
            
        } catch (Exception exception) {
            System.err.println("" + exception.getMessage());
        }
    }
    
    
}
