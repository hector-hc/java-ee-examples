
/**
 * @Class ZipCodeBean
 * @author Hector
 * @Created on Jul 21, 2019, 7:35:26 PM
 */

package javaee.examples.bean.validation.zipcode;

import javax.inject.Inject;
import org.slf4j.Logger;

public class ZipCodeBean {
    @Inject Logger logger;
    
    public void saveZipMexico(@ZipCode(country = ZipCode.Country.MEXICO, parameter = "Zip Code :)") String zip) {
        logger.info("zip code saved");
    }
}
