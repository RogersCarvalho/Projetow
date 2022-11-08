package com.educaweb.projetow.model.entidade;

import com.educaweb.projetow.model.entidade.PK.OrderItemPk;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;




@Entity
@Table(name="tb_order_item")
public class OrdemItem implements Serializable {

    @EmbeddedId
    private OrderItemPk Id = new OrderItemPk();

    private Integer quantity;
    private Double price;

    public OrdemItem() {}


    public OrdemItem(Order order,Product product,Integer quantity, Double price) {
        Id.setOrder(order);
        Id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }


    public Order getOrder(){return Id.getOrder();}
    public Product getProduct(){return Id.getProduct();}
    public Integer getQuantity() {return quantity;}
    public Double getPrice() {return price;}

    public void setOrder(Order order){Id.setOrder(order);}
    public void setProduct(Product Product){Id.setProduct(Product);}
    public void setQuantity(Integer quantity) {this.quantity = quantity;}
    public void setPrice(Double price) {this.price = price;}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdemItem ordemItem = (OrdemItem) o;
        return Id.equals(ordemItem.Id);
    }

    @Override
    public int hashCode() {
        return Id.hashCode();
    }
}
