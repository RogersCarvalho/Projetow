package com.educaweb.projetow.model.entidade;

import com.educaweb.projetow.model.entidade.PK.OrderItemPk;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="tb_order_item")
public class OrdemItem implements Serializable {

    @EmbeddedId
    private OrderItemPk id = new OrderItemPk();

    private Integer quantity;
    private Double price;


    public OrdemItem() {}
    public OrdemItem(Order order,Product product,Integer quantity, Double price) {
        id.setOrder(order);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }

    @JsonIgnore
    public Order getOrder(){return id.getOrder();}
    public Product getProduct(){return id.getProduct();}

    public Integer getQuantity() {return quantity;}
    public Double getPrice() {return price;}

    public void setOrder(Order order){id.setOrder(order);}
    public void setProduct(Product Product){id.setProduct(Product);}
    public void setQuantity(Integer quantity) {this.quantity = quantity;}
    public void setPrice(Double price) {this.price = price;}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdemItem ordemItem = (OrdemItem) o;
        return id.equals(ordemItem.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
