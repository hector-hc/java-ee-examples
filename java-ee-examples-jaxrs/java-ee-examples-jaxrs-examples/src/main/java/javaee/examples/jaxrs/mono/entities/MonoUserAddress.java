
/**
 * @Class MonoUserAddress
 * @author Hector
 * @Created on Jun 24, 2019, 8:15:54 AM
 */

package javaee.examples.jaxrs.mono.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "mono_user_address")
public class MonoUserAddress implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @JoinColumn(name = "user_id")
    @ManyToOne
    private MonoUser monoUser;
    
    private String street;
    
    private String number;
    
    private String city;
    
    private String zip;
    
    public MonoUserAddress() {
    }
    
    public MonoUserAddress(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MonoUser getMonoUser() {
        return monoUser;
    }

    public void setMonoUser(MonoUser monoUser) {
        this.monoUser = monoUser;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MonoUserAddress)) {
            return false;
        }
        MonoUserAddress other = (MonoUserAddress) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaee.examples.jaxrs.mono.entities.MonoUserAddress[ id=" + id + " ]";
    }

}
