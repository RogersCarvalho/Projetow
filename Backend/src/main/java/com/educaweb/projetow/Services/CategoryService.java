package com.educaweb.projetow.Services;

import com.educaweb.projetow.Repositories.CategoryRepository;
import com.educaweb.projetow.Repositories.UserRepository;
import com.educaweb.projetow.model.entidade.Category;
import com.educaweb.projetow.model.entidade.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CategoryService {

  @Autowired
  private CategoryRepository repository;


  public List<Category> findAll() {
      return repository.findAll();
  }

  public Category findById(Long id){
      Optional<Category> obj = repository.findById(id);
      return obj.get();
  }









}
