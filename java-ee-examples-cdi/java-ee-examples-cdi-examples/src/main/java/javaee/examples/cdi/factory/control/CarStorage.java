
/**
 * @Class CarStorage
 * @author Hector
 * @Created on Jul 14, 2019, 7:38:04 PM
 */

package javaee.examples.cdi.factory.control;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import javaee.examples.cdi.factory.entity.Car;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;

@Singleton
public class CarStorage {

    private final Map<Integer, Car> cars = new ConcurrentHashMap<>();
    
    private final AtomicInteger sequence = new AtomicInteger(1);
    
    @Lock
    public void store(Car car) {
        Integer id = sequence.getAndIncrement();
        car.setId(id);
        cars.put(id, car);
    }
    
    @Lock(LockType.READ)
    public Car retrieve(Integer id) {
        return cars.get(id);
    }
}
