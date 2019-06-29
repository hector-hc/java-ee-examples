
/**
 * @Class AsyncCdiServlet
 * @author Hector
 * @Created on Jun 29, 2019, 10:21:16 AM
 */

package javaee.examples.servlets.async.cdi;

import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AsyncCdiServlet", asyncSupported = true, urlPatterns = {"/AsyncCdiServlet"})
public class AsyncCdiServlet extends HttpServlet {

    @Inject
    UserService userService;
    
    private final Jsonb jsonb = JsonbBuilder.create();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        AsyncContext ctx = request.startAsync();
        ctx.start(() -> {
            try (PrintWriter out = response.getWriter()) {
                out.write(jsonb.toJson(userService.getUser()));
            } catch (IOException ioe) {
                System.err.println("" + ioe.getMessage());
            }
        });
    }
    
    
    
    public void destroy() {
        try {
            jsonb.close();
        } catch (Exception e) {
            System.err.println("" + e.getMessage());
        }
    }
}
