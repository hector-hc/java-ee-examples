
/**
 * @Class Car
 * @author Hector
 * @Created on Jul 14, 2019, 7:34:58 PM
 */

package javaee.examples.cdi.factory.entity;

import java.util.Objects;

public class Car {
    private Integer id;
    private Specification specification;
    
    public Car() {
    }
    
    public Car(Specification specification) {
        this.specification = specification;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Specification getSpecification() {
        return specification;
    }

    public void setSpecification(Specification specification) {
        this.specification = specification;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.specification);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Car other = (Car) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.specification, other.specification)) {
            return false;
        }
        return true;
    }
    
    
}
