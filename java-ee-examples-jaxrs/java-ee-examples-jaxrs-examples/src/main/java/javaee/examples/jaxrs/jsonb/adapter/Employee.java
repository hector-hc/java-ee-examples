/*
* Classname:    Employee.java
* Author:       Héctor Hernández Chávez
* Date:         16-jul-2019
*/
package javaee.examples.jaxrs.jsonb.adapter;

import javax.json.bind.annotation.JsonbTransient;
import javax.json.bind.annotation.JsonbTypeAdapter;

/**
 * @author Héctor Hernández Chávez
 */
public class Employee {

    @JsonbTransient
    private long id;
    
    private String name;
    
    private String email;
    
    @JsonbTypeAdapter(value = OrganizationTypeAdapter.class)
    private Organization organization;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
    
}
