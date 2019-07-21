/**
 * @Class OrderLine
 * @author Hector
 * @Created on Jul 21, 2019, 3:01:25 PM
 */
package javaee.examples.bean.validation.groups;

public class OrderLine {

    private String item;
    private Double unitPrice;
    private Integer quantity;

    public OrderLine() {
    }

    public OrderLine(String item, Double unitPrice, Integer quantity) {
        this.item = item;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
