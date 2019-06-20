/*
* Classname:    UserFormatted.java
* Author:       Héctor Hernández Chávez
* Date:         20-jun-2019
*/
package javaee.examples.jsonb.se;

import java.util.Date;
import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTransient;

/**
 * @author Héctor Hernández Chávez
 */
public class UserFormatted {

    private Long id;
    
    @JsonbProperty("fullName")
    private String name;
    
    private String email;
    
    @JsonbTransient
    private Double privateNumber;
    
    @JsonbDateFormat(JsonbDateFormat.DEFAULT_LOCALE)
    private Date dateCreated;

    public UserFormatted(Long id, String name, String email, Double privateNumber, Date dateCreated) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.privateNumber = privateNumber;
        this.dateCreated = dateCreated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Double getPrivateNumber() {
        return privateNumber;
    }

    public void setPrivateNumber(Double privateNumber) {
        this.privateNumber = privateNumber;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
    
}
