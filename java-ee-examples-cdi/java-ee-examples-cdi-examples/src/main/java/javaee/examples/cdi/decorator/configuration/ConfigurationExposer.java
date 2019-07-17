/*
* Classname:    ConfigurationExposer.java
* Author:       Héctor Hernández Chávez
* Date:         17-jul-2019
*/
package javaee.examples.cdi.decorator.configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Singleton;

/**
 * @author Héctor Hernández Chávez
 */
//@ApplicationScoped
//@Singleton
public class ConfigurationExposer {

    private final Properties properties = new Properties();
    
    //@PostConstruct
    private void initProperties() {
        try (final InputStream inputStream = ConfigurationExposer.class.getResourceAsStream("/META-INF/application.properties")) {
            properties.load(inputStream);
        } catch (IOException ioe) {
            throw new IllegalStateException("Could not init configuration ", ioe);
        }
    }
    
    //@Produces
    //@Config(value = "")
    public String exposeConfig(InjectionPoint injectionPoint) {
        final Config config = injectionPoint.getAnnotated().getAnnotation(Config.class);
        if (config != null) {
            return properties.getProperty(config.value());
        }
        return null;
    }
}
