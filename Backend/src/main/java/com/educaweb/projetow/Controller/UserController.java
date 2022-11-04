package com.educaweb.projetow.Controller;


import com.educaweb.projetow.Services.UserService;
import com.educaweb.projetow.model.entidade.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

       @Autowired
       private UserService service;


       @GetMapping
       public ResponseEntity<List<User>> findall(){

           List<User> lista = service.findAll();
           return ResponseEntity.ok().body(lista);

       }


    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){

        User user = service.findById(id);
        return ResponseEntity.ok().body(user);

    }




}



