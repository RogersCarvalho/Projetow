package com.educaweb.projetow.model.entidade;

import com.educaweb.projetow.model.entidade.enums.OrderStatus;
import com.educaweb.projetow.model.entidade.OrdemItem;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static com.educaweb.projetow.model.entidade.enums.OrderStatus.valueOf;

@Entity
@Table(name="tb_order")
public class Order implements Serializable {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private Instant moment;
     private Integer orderStatus;

     //@JsonIgnore
     @ManyToOne()
     @JoinColumn(name="id_cliente_user")
     private User cliente_user;

     //@JsonIgnore
     @OneToMany(mappedBy = "id.order")
     private Set<OrdemItem> items= new HashSet<>();


     public Order() {}
     public Order(Long id, Instant moment, User cliente_user, OrderStatus orderStatus) {

          this.moment = moment;
          this.cliente_user = cliente_user;
         setOrderStatus(orderStatus);
     }

     public Long getId() {return id;}
     public Instant getMoment() {return moment;}
     public User getCliente_user() {return cliente_user;}
     public void setId(Long id) {id = id;}
     public void setMoment(Instant moment) {this.moment = moment;}
     public void setCliente_user(User cliente_user) {this.cliente_user = cliente_user;}


     public OrderStatus getOrderStatus() {
          return OrderStatus.valueOf(orderStatus);
     }

     public void setOrderStatus(OrderStatus orderStatus) {
          if (orderStatus != null)
          this.orderStatus = orderStatus.getCode();
     }

     public Set<OrdemItem> getItems() {
          return items;
     }

     @Override
     public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || getClass() != o.getClass()) return false;
          Order order = (Order) o;
          return Objects.equals(id, order.id);
     }

     @Override
     public int hashCode() {
          return Objects.hash(id);
     }
}
