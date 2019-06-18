
/**
 * @Class ImplAdmin
 * @author Hector
 * @Created on Jun 17, 2019, 9:41:15 PM
 */

package javaee.examples.cdi.profile;

@Profile(ProfileType.ADMIN)
public class ImplAdmin implements UserProfile {

    @Override
    public ProfileType type() {
        System.out.println("User id Admin");
        return ProfileType.ADMIN;
    }

}
