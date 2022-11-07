package com.educaweb.projetow.Repositories;

import com.educaweb.projetow.model.entidade.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product,Long> {

}
