
/**
 * @Class ImplOperator
 * @author Hector
 * @Created on Jun 17, 2019, 9:40:20 PM
 */

package javaee.examples.cdi.profile;

import javax.enterprise.inject.Default;

@Profile(ProfileType.OPERATOR)
@Default
public class ImplOperator implements UserProfile {

    @Override
    public ProfileType type() {
        System.out.println("User is operator");
        return ProfileType.OPERATOR;
    }

}
