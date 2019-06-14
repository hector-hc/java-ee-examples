
/**
 * @Class User
 * @author Hector
 * @Created on Jun 14, 2019, 9:04:39 AM
 */

package javaee.bean.validation.simple;

import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;

public class User implements Serializable {
    
    public static final long serialVersionUID = 1L;
    
    @NotBlank
    private String name;
    
    @Email
    private String email;
    
    @NotEmpty
    private List<@PositiveOrZero Integer> profileId;
    
    public User() {
    }

    public User(String name, String email, List<Integer> profileId) {
        this.name = name;
        this.email = email;
        this.profileId = profileId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Integer> getProfileId() {
        return profileId;
    }

    public void setProfileId(List<Integer> profileId) {
        this.profileId = profileId;
    }
    
}
