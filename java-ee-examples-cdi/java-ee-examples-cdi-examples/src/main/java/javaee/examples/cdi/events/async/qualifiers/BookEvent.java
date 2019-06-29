/**
 * @Class BookEvent
 * @author Hector
 * @Created on Jun 29, 2019, 12:18:21 PM
 */
package javaee.examples.cdi.events.async.qualifiers;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class BookEvent {

    private BigDecimal book;
    private String storeName;
    private BigDecimal price;
    private int numBooks;
    private LocalDate date;
    private List<String> notifyList;

    public BigDecimal getBook() {
        return book;
    }

    public void setBook(BigDecimal book) {
        this.book = book;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getNumBooks() {
        return numBooks;
    }

    public void setNumBooks(int numBooks) {
        this.numBooks = numBooks;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<String> getNotifyList() {
        return notifyList;
    }

    public void setNotifyList(List<String> notifyList) {
        this.notifyList = notifyList;
    }
}
