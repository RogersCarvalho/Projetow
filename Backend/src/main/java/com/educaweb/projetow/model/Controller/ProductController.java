package com.educaweb.projetow.model.Controller;


import com.educaweb.projetow.Services.ProductService;
import com.educaweb.projetow.Services.UserService;
import com.educaweb.projetow.model.entidade.Product;
import com.educaweb.projetow.model.entidade.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductController {

       @Autowired
       private ProductService productService;


       @GetMapping
       public ResponseEntity<List<Product>> findall(){
           List<Product> lista = productService.findAll();
           return ResponseEntity.ok().body(lista);
       }


    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
           Product product = productService.findById(id);
           return ResponseEntity.ok().body(product);
       }




}



