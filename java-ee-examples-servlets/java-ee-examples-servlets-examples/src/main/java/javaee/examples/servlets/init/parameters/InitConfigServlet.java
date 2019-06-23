
/**
 * @Class InitConfigServler
 * @author Hector
 * @Created on Jun 22, 2019, 8:12:37 PM
 */

package javaee.examples.servlets.init.parameters;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "InitConfigServlet", urlPatterns = {"/InitConfigServlet"}, 
        initParams = {
            @WebInitParam(name = "key1", value = "value1"),
            @WebInitParam(name = "key2", value = "value2"),
            @WebInitParam(name = "key3", value = "value3"),
            @WebInitParam(name = "key4", value = "value4"),
            @WebInitParam(name = "key5", value = "value5")
        })
public class InitConfigServlet extends HttpServlet {
    
    Map<String, String> param = new HashMap<>();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) {
            if (param.isEmpty()) {
                out.println("No params to show");
            } else {
                param.forEach((k, v) -> out.println("param: " + k + ", value:" + v + "<br />"));
            }
        }
    }
    
    @Override
    public void init(ServletConfig config) {
        System.out.println("init");
        List<String> list = Collections.list(config.getInitParameterNames());
        list.forEach(key -> {
            param.put(key, config.getInitParameter(key));
        });
    }
}
