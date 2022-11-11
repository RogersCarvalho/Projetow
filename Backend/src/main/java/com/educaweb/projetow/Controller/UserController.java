package com.educaweb.projetow.Controller;


import com.educaweb.projetow.Services.UserService;
import com.educaweb.projetow.model.entidade.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;



@RestController
@RequestMapping("/users")
public class UserController {

       @Autowired
       private UserService userService;


       @GetMapping
       public ResponseEntity<List<User>> findall(){

           List<User> lista = userService.findAll();
           return ResponseEntity.ok().body(lista);

       }


    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){

        User user = userService.findById(id);
        return ResponseEntity.ok().body(user);

    }


    @PostMapping
    public ResponseEntity<User> Insert(@RequestBody User obj){

        User user = userService.Insert(obj);
        final var location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();

        return ResponseEntity.created(location).body(user);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Delete(@PathVariable Long id){

           userService.delete(id);
           return ResponseEntity.noContent().build();

    }


    @PutMapping("/{id}")
    public ResponseEntity<User> Update(@PathVariable Long id,@RequestBody User obj){

           User user = userService.Update(id, obj);
           return ResponseEntity.ok().body(user);

       }





}



