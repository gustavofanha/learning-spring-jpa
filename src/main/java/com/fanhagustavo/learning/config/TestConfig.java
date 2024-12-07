package com.fanhagustavo.learning.config;

import com.fanhagustavo.learning.entities.User;
import com.fanhagustavo.learning.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User(null, "José Almeida", "josealmeida@gmail.com", "988888888", "123456");
        User user2 = new User(null, "Evandro Sales", "evandrosales@gmail.com", "977777777", "123456");

        userRepository.saveAll(Arrays.asList(user1, user2));

    }
}
