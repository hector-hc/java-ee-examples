
/**
 * @Class LoadOnStartupServlet
 * @author Hector
 * @Created on Jun 22, 2019, 8:06:58 PM
 */

package javaee.examples.servlets.onload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "LoadOnStartupServlet", urlPatterns = {"/LoadOnStartupServlet"}, loadOnStartup = 1)
public class LoadOnStartupServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("*******SERVLET LOADED WITH SERVER STARTUP*******");
    }
}
