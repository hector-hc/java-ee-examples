
/**
 * @Class SecutityServlet
 * @author Hector
 * @Created on Jun 22, 2019, 10:12:15 PM
 */

package javaee.examples.secutiry.realm.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SecutityServlet", urlPatterns = {"/security/SecutityServlet"})
public class SecutityServlet extends HttpServlet {

    @Inject
    Principal principal;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            out.println("User Principal Name: " + principal.getName());
        }
    }
    
    
}
