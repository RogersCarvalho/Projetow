package com.educaweb.projetow.Repositories;

import com.educaweb.projetow.model.entidade.OrdemItem;
import com.educaweb.projetow.model.entidade.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdemItemRepository extends JpaRepository<OrdemItem,Long> {



}
