package com.educaweb.projetow.Controller;


import com.educaweb.projetow.Services.OrderService;
import com.educaweb.projetow.Services.UserService;
import com.educaweb.projetow.model.entidade.Order;
import com.educaweb.projetow.model.entidade.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/orders")
public class OrderController {

       @Autowired
       private OrderService service;


       @GetMapping
       public ResponseEntity<List<Order>> findall(){

           List<Order> lista = service.findAll();
           return ResponseEntity.ok().body(lista);

       }

    @GetMapping("/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id){

        Order order = service.findById(id);
        return ResponseEntity.ok().body(order);

    }




}



