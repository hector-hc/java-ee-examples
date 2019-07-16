/*
* Classname:    UserStore.java
* Author:       Héctor Hernández Chávez
* Date:         16-jul-2019
*/
package javaee.examples.jaxrs.bean.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 * @author Héctor Hernández Chávez
 */
@Singleton
@Startup
public class UserStore {
    
    private Queue<User> cache = null;
    
    private final AtomicInteger id = new AtomicInteger(1);
    
    @PostConstruct
    private void init() {
        cache = new ConcurrentLinkedDeque<>();
        loadCache();
    }
    
    @Lock(LockType.READ)
    public List<User> getUsers() {
        return cache.stream().collect(Collectors.toList());
    }
    
    @Lock(LockType.READ)
    public Optional<User> getByUserId(long id) {
        return this.cache.stream().filter(u -> u.getId() == id).findFirst();
    }
    
    @Lock(LockType.WRITE)
    public User addUser(User user) {
        user.setId(id.getAndIncrement());
        this.cache.add(user);
        return user;
    }
    
    @Lock(LockType.READ)
    public boolean isNamedTaken(String name) {
        return this.cache.stream().filter(u -> u.getName().equals(name)).findAny().isPresent();
    }
    
    private void loadCache() {
        List<User> listUsers = new ArrayList<>();
        User user = new User(id.getAndIncrement(), "hector");
        user.setEmail("hector@gmail.com");
        listUsers.add(user);
        listUsers.forEach(cache::add);
    }
}
