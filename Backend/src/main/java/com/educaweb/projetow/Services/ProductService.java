package com.educaweb.projetow.Services;

import com.educaweb.projetow.Repositories.ProductRepository;
import com.educaweb.projetow.Repositories.UserRepository;
import com.educaweb.projetow.model.entidade.Product;
import com.educaweb.projetow.model.entidade.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductService {

  @Autowired
  private ProductRepository productRepository;

  public List<Product> findAll() {

      return productRepository.findAll();
  }

  public Product findById(Long id){
      Optional<Product> obj = productRepository.findById(id);
      return obj.get();
  }









}
