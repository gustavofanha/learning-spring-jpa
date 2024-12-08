package com.fanhagustavo.learning.config;

import com.fanhagustavo.learning.entities.Order;
import com.fanhagustavo.learning.entities.User;
import com.fanhagustavo.learning.repositories.OrderRepository;
import com.fanhagustavo.learning.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User(null, "José Almeida", "josealmeida@gmail.com", "988888888", "123456");
        User user2 = new User(null, "Evandro Sales", "evandrosales@gmail.com", "977777777", "123456");

        Order order1 = new Order(null, Instant.parse("2022-06-20T19:53:07Z"), user1);
        Order order2 = new Order(null, Instant.parse("2022-07-21T20:00:00Z"), user2);
        Order order3 = new Order(null, Instant.parse("2022-06-25T17:32:10Z"), user1);

        userRepository.saveAll(Arrays.asList(user1, user2));
        orderRepository.saveAll(Arrays.asList(order1, order2, order3));
    }

}
