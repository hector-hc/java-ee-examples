
/**
 * @Class UserController
 * @author Hector
 * @Created on Jun 16, 2019, 3:22:08 PM
 */

package javaee.examples.mvc.controllers;

import javaee.examples.mvc.beans.UserBean;
import javaee.examples.mvc.model.User;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Models;
import javax.mvc.annotation.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Controller
@Path("usercontroller")
public class UserController {
    
    @Inject
    Models models;
    
    @Inject
    UserBean userBean;

    @GET
    public String user() {
        models.put("user", userBean.getUser());
        return "/user.jsp";
    }
}
