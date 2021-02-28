package com.ilab.login.config;

import com.ilab.login.domain.User;
import com.ilab.login.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Test {
    @Bean
    CommandLineRunner runner (UserRepository userRepository){
        return args -> {
            userRepository.save(new User("username", "password"));
        };
    }
}
