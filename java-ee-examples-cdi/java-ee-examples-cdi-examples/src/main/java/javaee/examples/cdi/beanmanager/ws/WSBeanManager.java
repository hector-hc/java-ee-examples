
/**
 * @Class WSBeanManager
 * @author Hector
 * @Created on Jul 20, 2019, 9:07:53 PM
 */

package javaee.examples.cdi.beanmanager.ws;

import java.util.Set;
import java.util.stream.Collectors;
import javaee.examples.cdi.beanmanager.GreetingBeanManager;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.CDI;
import javax.inject.Inject;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("bean-manager")
public class WSBeanManager {

    @Inject
    private BeanManager beanManager;
    
    private BeanManager bmCDI;
    
    private BeanManager bmLookup;
    
    @PostConstruct
    private void init() {
        bmCDI = CDI.current().getBeanManager();
        try {
            bmLookup = InitialContext.doLookup("java:comp/BeanManager");
        } catch (NamingException me) {
            System.out.println("WSBeanManager " + me.getMessage());
        }
    }
    
    @GET
    public Response getGreetByBeanManager() {
        Set<Bean<?>> beans = beanManager.getBeans(GreetingBeanManager.class);
        Set<String> beanClassNames = beans.stream().map(b -> b.getBeanClass().getName())
                .collect(Collectors.toSet());
        Set<Bean<?>> beansCDI = bmCDI.getBeans(GreetingBeanManager.class);
        Set<String> beanClassNamesCDI = beansCDI.stream()
                .map(b -> b.getBeanClass().getName()).collect(Collectors.toSet());
         beanClassNamesCDI.forEach(b -> {
             System.out.println("bean_name_CDI: " + b);
        });
        
        Set<Bean<?>> beansLookup = bmLookup.getBeans(GreetingBeanManager.class);
        Set<String> beanClassNamesLookup = beansLookup.stream()
                .map(b -> b.getBeanClass().getName()).collect(Collectors.toSet());
        
        beanClassNamesLookup.forEach(b -> {
            System.out.println("bean_name_Lookup: " + b);
        });
        return Response.ok(beanClassNames.size()).build();
    }
}
