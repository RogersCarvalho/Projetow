package com.educaweb.projetow.Config;

import com.educaweb.projetow.Repositories.CategoryRepository;
import com.educaweb.projetow.Repositories.OrderRepository;
import com.educaweb.projetow.Repositories.UserRepository;
import com.educaweb.projetow.model.entidade.Category;
import com.educaweb.projetow.model.entidade.Order;
import com.educaweb.projetow.model.entidade.User;
import com.educaweb.projetow.model.entidade.enums.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;



//O objetivo é, ao rodar a aplicação, inserir dados na tabela User
//Precisa ser informado o nome test, pois é o tipo de perfil de teste usado
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CategoryRepository categoryRepository;


    //Método que sempre executa ao rodar a aplicação
    @Override
    public void run(String... args) throws Exception {


        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        Order ped1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1, OrderStatus.PAID);
        Order ped2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2, OrderStatus.WAITING_PAYMENT);
        Order ped3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1, OrderStatus.WAITING_PAYMENT);
        Order ped4 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1, OrderStatus.CANCELED);


        categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
        userRepository.saveAll(Arrays.asList(u1,u2));
        orderRepository.saveAll(Arrays.asList(ped1,ped2,ped3,ped4));


    }







}
