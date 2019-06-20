/*
* Classname:    ProfileServlet.java
* Author:       Héctor Hernández Chávez
* Date:         20-jun-2019
*/
package javaee.examples.servlets.server.push;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Héctor Hernández Chávez
 */
@WebServlet(name = "ProfileServlet", urlPatterns = {"/push/ProfileServlet"})
public class ProfileServlet extends HttpServlet {

    protected void doRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/profile.jsp").forward(request, response);
        System.out.println("Redirected to profile.jsp");
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "ProfileServlet for ServerPush";
    }
}
