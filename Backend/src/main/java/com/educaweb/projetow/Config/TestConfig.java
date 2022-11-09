package com.educaweb.projetow.Config;

import com.educaweb.projetow.Repositories.*;
import com.educaweb.projetow.model.entidade.*;
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

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrdemItemRepository  ordemItemRepository;


    //Método que sempre executa ao rodar a aplicação
    @Override
    public void run(String... args) throws Exception {



        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        Order ped1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1, OrderStatus.PAID);
        Order ped2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2, OrderStatus.WAITING_PAYMENT);
        Order ped3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1, OrderStatus.WAITING_PAYMENT);
        Order ped4 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1, OrderStatus.CANCELED);


        userRepository.saveAll(Arrays.asList(u1,u2));
        orderRepository.saveAll(Arrays.asList(ped1,ped2,ped3,ped4));



        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");


        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
        categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));

        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p2.getCategories().add(cat3);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);

        productRepository.saveAll((Arrays.asList(p1,p2,p3,p4,p5)));


        OrdemItem oi1 = new OrdemItem(ped1, p1, 2, p1.getPrice());
        OrdemItem oi2 = new OrdemItem(ped1, p3, 1, p3.getPrice());
        OrdemItem oi3 = new OrdemItem(ped2, p3, 2, p3.getPrice());
        OrdemItem oi4 = new OrdemItem(ped3, p5, 2, p5.getPrice());

        ordemItemRepository.saveAll((Arrays.asList(oi1,oi2,oi3,oi4)));

        //Cadastrar pagamento
       Payment pay =new Payment(null, Instant.parse("2019-06-20T21:53:07Z"),ped1);
       ped1.setPayment(pay);

       orderRepository.saveAll(Arrays.asList(ped1));

    }







}
