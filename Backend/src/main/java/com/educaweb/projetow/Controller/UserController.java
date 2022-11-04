package com.educaweb.projetow.Controller;


import com.educaweb.projetow.model.entidade.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/users")
public class UserController {

       @GetMapping
       public ResponseEntity<User> findall(){

           var user = new User(1L,"Teste", "teste@yahoo.com.br","(32)99174-0603","1234");
           return ResponseEntity.ok().body(user);

       }






}



