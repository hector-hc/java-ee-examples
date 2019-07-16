/*
* Classname:    OrganizationStore.java
* Author:       Héctor Hernández Chávez
* Date:         16-jul-2019
*/
package javaee.examples.jaxrs.jsonb.adapter;

/**
 * @author Héctor Hernández Chávez
 */
public class OrganizationStore {

    public Organization getOrganization(long id) {
        Organization organization = new Organization();
        organization.setId(id);
        return organization;
    }
}
