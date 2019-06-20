/*
* Classname:    PushFilter.java
* Author:       Héctor Hernández Chávez
* Date:         20-jun-2019
*/
package javaee.examples.servlets.server.push.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.PushBuilder;

/**
 * @author Héctor Hernández Chávez
 */
@WebFilter(filterName = "PushFilter", urlPatterns = {"/push/*"})
public class PushFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, 
            FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        PushBuilder builder = httpRequest.newPushBuilder();
        if (builder != null) {
            builder
                .path("resources/javaee-logo.png")
                .path("resources/style.css")
                .path("resources/functions.js")
                .push();            
            System.out.println("Resources pushed");
        } else {
            System.out.println("Server Push not enable");
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

}
