
/**
 * @Class UserTest
 * @author Hector
 * @Created on Jun 14, 2019, 9:07:07 AM
 */

package javaee.bean.validation.simple;

import java.util.Arrays;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserTest {
    
    // /Users/Hector/Documents/workspace_github/java-ee-examples/java-ee-examples-bean-validation/java-ee-examples-bean-validation-examples
    // mvn -Dtest=javaee.bean.validation.simple.UserTest test
    
    private static Validator validator;
    
    @BeforeClass
    public static void setUpClass() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }
    
    @Test
    public void validUser() {
        User user = new User("hector", "hector.hernandez@gmail.com", Arrays.asList(1, 2));
        Set<ConstraintViolation<User>> cv = validator.validate(user);
        Assert.assertTrue(cv.isEmpty());
    }
    
    @Test
    public void invalidName() {
        User user = new User("", "hector.hernandez@gmail.com", Arrays.asList(1, 2));
        Set<ConstraintViolation<User>> cv = validator.validate(user);
        Assert.assertEquals(1, cv.size());
    }
    
    @Test
    public void invalidMail() {
        User user = new User("hector", "hector.hernandez-gmail.com", Arrays.asList(1, 2));
        Set<ConstraintViolation<User>> cv = validator.validate(user);
        Assert.assertEquals(1, cv.size());
    }
    
    @Test
    public void invalidId() {
        User user = new User("hector", "hector.hernandez@gmail.com", Arrays.asList(-1, -2, 1, 2));
        Set<ConstraintViolation<User>> cv = validator.validate(user);
        Assert.assertEquals(2, cv.size());
    }
}
