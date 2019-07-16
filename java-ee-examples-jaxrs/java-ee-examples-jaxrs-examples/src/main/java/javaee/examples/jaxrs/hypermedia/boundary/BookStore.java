/*
* Classname:    BookStore.java
* Author:       Héctor Hernández Chávez
* Date:         16-jul-2019
*/
package javaee.examples.jaxrs.hypermedia.boundary;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.stream.Collectors;
import javaee.examples.jaxrs.hypermedia.entity.Book;
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
public class BookStore {

    protected Queue<Book> cache = null;
    
    @PostConstruct
    protected void init() {
        cache = new ConcurrentLinkedDeque<>();
        loadCache();
    }
    
    @Lock(LockType.READ)
    public List<Book> get() {
        return cache.stream().collect(Collectors.toList());
    }
    
    @Lock(LockType.READ)
    public Optional<Book> getById(final long id) {
        return this.cache.stream().filter(b -> b.getId() == id).findFirst();
    }
    
    protected void loadCache() {
        List<Book> listBooks = new ArrayList<>();
        Book book01 = new Book();
        book01.setId(1);
        book01.setName("Java Design Patterns");
        book01.setAuthor("Vaskaran Sarcar");
        book01.setIsbn("978-1-4842-4077-9");
        listBooks.add(book01);
        Book book02 = new Book();
        book02.setId(2);
        book02.setName("Cloud-Native Microservices with Jakarta EE");
        book02.setAuthor("Mauro Vocale");
        book02.setIsbn("978-1-7883-786-6");
        listBooks.add(book02);
        listBooks.forEach(cache::add);
    }
}
