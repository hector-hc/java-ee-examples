
/**
 * @Class Action
 * @author Hector
 * @Created on Jul 22, 2019, 8:47:04 PM
 */

package javaee.examples.batch.simple.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Auction implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "seq_auction_gen", initialValue = 1, allocationSize = 1, sequenceName = "seq_auction")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_auction_gen")
    private Long id;
    
    private String item;
    
    private Long bid;
    
    private long buyout;
    
    private Integer quantity;
    
    public Auction() {
    }

    public Auction(final Long id, final String item, final Long bid, final Long buyout, final Integer quantity) {
        this.id = id;
        this.item = item;
        this.bid = bid;
        this.buyout = buyout;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Long getBid() {
        return bid;
    }

    public void setBid(Long bid) {
        this.bid = bid;
    }

    public long getBuyout() {
        return buyout;
    }

    public void setBuyout(long buyout) {
        this.buyout = buyout;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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
        if (!(object instanceof Auction)) {
            return false;
        }
        Auction other = (Auction) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaee.examples.batch.simple.entities.Auction[ id=" + id + " ]";
    }
}
