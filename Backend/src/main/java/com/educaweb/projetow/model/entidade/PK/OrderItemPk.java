package com.educaweb.projetow.model.entidade.PK;

import com.educaweb.projetow.model.entidade.Order;
import com.educaweb.projetow.model.entidade.Product;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;


@Embeddable
public class OrderItemPk implements Serializable  {

    @ManyToOne
    @JoinColumn(name="id_order")
    private Order order;

    @ManyToOne
    @JoinColumn(name="id_product")
    private Product product;


    public Order getOrder() {
        return order;
    }
    public Product getProduct() {
        return product;
    }
    public void setOrder(Order order) {
        this.order = order;
    }
    public void setProduct(Product product) {
        this.product = product;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderItemPk that = (OrderItemPk) o;

        if (!order.equals(that.order)) return false;
        return product.equals(that.product);
    }

    @Override
    public int hashCode() {
        int result = order.hashCode();
        result = 31 * result + product.hashCode();
        return result;
    }


}
