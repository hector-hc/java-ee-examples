
/**
 * @Class AsyncServlet
 * @author Hector
 * @Created on Jun 22, 2019, 8:23:09 PM
 */

package javaee.examples.servlets.async;

import java.io.IOException;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AsyncServlet", urlPatterns = {"/AsyncServlet"},asyncSupported = true)
public class AsyncServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        long startTime = System.currentTimeMillis();
        System.out.println("AsyncServlet Begin, Name=" + Thread.currentThread().getName() 
                + ", ID=" + Thread.currentThread().getId());
        String time = request.getParameter("timestamp");
        AsyncContext asyncCtx = request.startAsync();
        asyncCtx.start(() -> {
            try {
                Thread.sleep(Long.valueOf(time));
                long endTime = System.currentTimeMillis();
                long timeElapsed = endTime - startTime;
                System.out.println("AsyncServlet Finish, Name="
                        + Thread.currentThread().getName() + ", ID="
                        + Thread.currentThread().getId() + ", Duration="
                        + timeElapsed + " milliseconds.");
                asyncCtx.getResponse().getWriter().write("Async process time: " + timeElapsed + " milliseconds");
                asyncCtx.complete();
            } catch (InterruptedException | IOException e) {
                System.out.println("" + e.getMessage());
            }
        });
    }
    
    
}
