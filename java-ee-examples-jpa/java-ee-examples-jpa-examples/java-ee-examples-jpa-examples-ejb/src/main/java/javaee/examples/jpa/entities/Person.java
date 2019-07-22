
/**
 * @Class Person
 * @author Hector
 * @Created on Jul 21, 2019, 8:08:45 PM
 */

package javaee.examples.jpa.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Person implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "seq_person_gen", initialValue = 1, allocationSize = 1, sequenceName = "seq_person")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_person_gen")
    private Long id;
    
    private String name;
    
    @Column(name = "birth_date")
    private LocalDate birthDate;
    
    @Column(name = "create_date")
    private LocalDateTime createDate;

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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
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
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Person[ id=" + id + " ]";
    }
}
