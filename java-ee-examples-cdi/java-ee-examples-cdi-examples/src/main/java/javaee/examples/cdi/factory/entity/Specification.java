
/**
 * @Class Specification
 * @author Hector
 * @Created on Jul 14, 2019, 7:33:42 PM
 */

package javaee.examples.cdi.factory.entity;

import java.util.Objects;

public class Specification {
    private EngineType engine;
    private Color color;

    public EngineType getEngine() {
        return engine;
    }

    public void setEngine(EngineType engine) {
        this.engine = engine;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.engine);
        hash = 23 * hash + Objects.hashCode(this.color);
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
        final Specification other = (Specification) obj;
        if (this.engine != other.engine) {
            return false;
        }
        if (this.color != other.color) {
            return false;
        }
        return true;
    }
    
    
}
