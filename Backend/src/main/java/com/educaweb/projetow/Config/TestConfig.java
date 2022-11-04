package com.educaweb.projetow.Config;

import com.educaweb.projetow.Repositories.UserRepository;
import com.educaweb.projetow.model.entidade.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;



//O objetivo é, ao rodar a aplicação, inserir dados na tabela User
//Precisa ser informado o nome test, pois é o tipo de perfil de teste usado
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    //Método que sempre executa ao rodar a aplicação
    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        userRepository.saveAll(Arrays.asList(u1,u2));
    }





}
