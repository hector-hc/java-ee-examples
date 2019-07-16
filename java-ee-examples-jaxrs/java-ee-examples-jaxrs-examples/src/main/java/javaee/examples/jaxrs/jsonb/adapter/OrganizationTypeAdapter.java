/*
* Classname:    OrganizationTypeAdapter.java
* Author:       Héctor Hernández Chávez
* Date:         16-jul-2019
*/
package javaee.examples.jaxrs.jsonb.adapter;

import javax.inject.Inject;
import javax.json.bind.adapter.JsonbAdapter;

/**
 * @author Héctor Hernández Chávez
 */
public class OrganizationTypeAdapter implements JsonbAdapter<Organization, String> {

    @Inject
    OrganizationStore organizationStore;
    
    @Override
    public String adaptToJson(Organization orgnl) throws Exception {
        System.out.println("Organization.getId " + orgnl.getId());
        return String.valueOf(orgnl.getId());
    }

    @Override
    public Organization adaptFromJson(String adptd) throws Exception {
        long id = Long.parseLong(adptd);
        Organization organization = organizationStore.getOrganization(id);
        if (organization == null) {
            throw new IllegalArgumentException("Could not find organization for ID " + adptd);
        }
        return organization;
    }

}
