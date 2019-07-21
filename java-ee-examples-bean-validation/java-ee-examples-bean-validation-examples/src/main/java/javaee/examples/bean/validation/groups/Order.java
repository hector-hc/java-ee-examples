
/**
 * @Class Order
 * @author Hector
 * @Created on Jul 21, 2019, 3:04:51 PM
 */

package javaee.examples.bean.validation.groups;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

@ChronologicalDates(groups = Delivery.class)
public class Order {
    @NotNull(groups = {Creation.class})
    private Long id;
    @NotNull(groups = {Creation.class, Payment.class, Delivery.class})
    @Past(groups = {Creation.class, Payment.class, Delivery.class})
    private LocalDate creationDate;
    @NotNull(groups = {Creation.class, Payment.class, Delivery.class})
    private Double totalAmount;
    @NotNull(groups = {Payment.class, Delivery.class})
    @Past(groups = {Payment.class, Delivery.class})
    private LocalDate paymentDate;
    @NotNull(groups = Delivery.class)
    @Past(groups = Delivery.class)
    private LocalDate deliveryDate;
    private List<OrderLine> orderLines;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }
    
    public void addOrderLine(final OrderLine orderLine) {
        if (this.orderLines == null) {
            this.orderLines = new ArrayList<>();
        }
        this.orderLines.add(orderLine);
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", creationDate=" + creationDate 
                + ", totalAmount=" + totalAmount + ", paymentDate=" + paymentDate 
                + ", deliveryDate=" + deliveryDate + ", orderLines=" + orderLines + '}';
    }
}
