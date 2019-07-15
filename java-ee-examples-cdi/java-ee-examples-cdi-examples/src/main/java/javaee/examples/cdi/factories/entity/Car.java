
/**
 * @Class Car
 * @author Hector
 * @Created on Jul 14, 2019, 8:22:29 PM
 */

package javaee.examples.cdi.factories.entity;

public class Car {
    private Integer id;
    private EngineType engine;
    private Color color;
    
    public LogBook createDriverLog() {
        return new LogBook();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
    
}
