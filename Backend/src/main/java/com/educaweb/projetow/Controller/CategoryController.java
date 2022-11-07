package com.educaweb.projetow.Controller;


import com.educaweb.projetow.Services.CategoryService;
import com.educaweb.projetow.Services.UserService;
import com.educaweb.projetow.model.entidade.Category;
import com.educaweb.projetow.model.entidade.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/categories")
public class CategoryController {

       @Autowired
       private CategoryService categoryService;


       @GetMapping
       public ResponseEntity<List<Category>> findall(){
           List<Category> lista = categoryService.findAll();
           return ResponseEntity.ok().body(lista);
       }


        @GetMapping("/{id}")
        public ResponseEntity<Category> findById(@PathVariable Long id){
            Category Category = categoryService.findById(id);
            return ResponseEntity.ok().body(Category);
        }




}



