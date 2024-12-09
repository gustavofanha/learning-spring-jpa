package com.fanhagustavo.learning.config;

import com.fanhagustavo.learning.entities.Category;
import com.fanhagustavo.learning.entities.Order;
import com.fanhagustavo.learning.entities.User;
import com.fanhagustavo.learning.entities.enums.OrderStatus;
import com.fanhagustavo.learning.repositories.CategoryRepository;
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

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User(null, "José Almeida", "josealmeida@gmail.com", "988888888", "123456");
        User user2 = new User(null, "Evandro Sales", "evandrosales@gmail.com", "977777777", "123456");

        Order order1 = new Order(null, Instant.parse("2022-06-20T19:53:07Z"), OrderStatus.PAID, user1);
        Order order2 = new Order(null, Instant.parse("2022-07-21T20:00:00Z"), OrderStatus.WAITING_PAYMENT, user2);
        Order order3 = new Order(null, Instant.parse("2022-06-25T17:32:10Z"), OrderStatus.WAITING_PAYMENT, user1);

        Category category1 = new Category(null, "Electronics");
        Category category2 = new Category(null, "Books");
        Category category3 = new Category(null, "Computers");

        userRepository.saveAll(Arrays.asList(user1, user2));
        orderRepository.saveAll(Arrays.asList(order1, order2, order3));
        categoryRepository.saveAll(Arrays.asList(category1, category2, category3));
    }

}
