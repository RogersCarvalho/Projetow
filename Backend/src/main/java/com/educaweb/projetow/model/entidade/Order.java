package com.educaweb.projetow.model.entidade;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name="tb_order")
public class Order implements Serializable {

     @javax.persistence.Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long Id;
     private Instant moment;

     @ManyToOne
     @JoinColumn(name="id_cliente_user")
     private User cliente_user;

     public Order() {}
     public Order(Long id, Instant moment, User cliente_user) {
          Id = id;
          this.moment = moment;
          this.cliente_user = cliente_user;
     }

     public Long getId() {return Id;}
     public Instant getMoment() {return moment;}
     public User getCliente_user() {return cliente_user;}

     public void setId(Long id) {Id = id;}
     public void setMoment(Instant moment) {this.moment = moment;}
     public void setCliente_user(User cliente_user) {this.cliente_user = cliente_user;}


     @Override
     public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || getClass() != o.getClass()) return false;
          Order order = (Order) o;
          return Objects.equals(Id, order.Id);
     }

     @Override
     public int hashCode() {
          return Objects.hash(Id);
     }
}
