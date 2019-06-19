/*
* Classname:    Country.java
* Author:       Héctor Hernández Chávez
* Date:         18-jun-2019
* © Concepto Móvil S.A. de C.V. 2014
*/
package javaee.examples.jpa.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Héctor Hernández Chávez
 */
@Entity
@Table(name = "cache_country")
@NamedQueries({
    @NamedQuery(name = Country.FIND_ALL, query = "SELECT c FROM Country c")
})
public class Country implements Serializable {

    private static final long serialVersionUID = 1L;
    
    public static final String FIND_ALL = "Country.findAll";
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String name;
    
    @Column(name = "iso_code_alpha2")
    private String isoCodeAlpha2;
    
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    
    public Country() {
    }
    
    public Country(final Long id) {
        this.id = id;
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

    public String getIsoCodeAlpha2() {
        return isoCodeAlpha2;
    }

    public void setIsoCodeAlpha2(String isoCodeAlpha2) {
        this.isoCodeAlpha2 = isoCodeAlpha2;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
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
        if (!(object instanceof Country)) {
            return false;
        }
        Country other = (Country) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaee.examples.cache.entities.Country[ id=" + id + " ]";
    }

}
