
/**
 * @Class WSUserService
 * @author Hector
 * @Created on Jun 17, 2019, 9:42:39 PM
 */

package javaee.examples.cdi.qualifiers.ws;

import java.io.IOException;
import javaee.examples.cdi.qualifiers.profile.Profile;
import javaee.examples.cdi.qualifiers.profile.ProfileType;
import javaee.examples.cdi.qualifiers.profile.User;
import javaee.examples.cdi.qualifiers.profile.UserProfile;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

@Path("qualifier/userservice")
public class WSQualifierUserService {

    @Inject
    private User user;
    
    @Inject
    @Profile(ProfileType.ADMIN)
    private UserProfile userProfileAdmin;
    
    @Inject
    @Profile(ProfileType.OPERATOR)
    private UserProfile userProfileOperator;
    
    @Inject @Default
    private UserProfile userProfileDefault;
    
    @Inject
    private Event<User> userEvent;
    
    @GET
    @Path("user")
    public Response getUser(@Context HttpServletRequest request, 
            @Context HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("result", user);
        request.getRequestDispatcher("/result.jsp").forward(request, response);
        return Response.ok().build();
    }
    
    @GET
    @Path("profileadmin")
    public Response getProfileAdmin(@Context HttpServletRequest request, 
            @Context HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("result", fireUserEvents(userProfileAdmin.type()));
        request.getRequestDispatcher("/result.jsp").forward(request, response);
        return Response.ok().build();
    }
    
    @GET
    @Path("profileoperator")
    public Response getProfileOperator(@Context HttpServletRequest request, 
            @Context HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("result", fireUserEvents(userProfileOperator.type()));
        request.getRequestDispatcher("/result.jsp").forward(request, response);
        return Response.ok().build();
    }
    
    @GET
    @Path("profiledefault")
    public Response getProfileDefault(@Context HttpServletRequest request, 
            @Context HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("result", fireUserEvents(userProfileDefault.type()));
        request.getRequestDispatcher("/result.jsp").forward(request, response);
        return Response.ok().build();
    }
    
    private ProfileType fireUserEvents(ProfileType type) {
        userEvent.fire(user);
        userEvent.fireAsync(user);
        return type;
    }
}
