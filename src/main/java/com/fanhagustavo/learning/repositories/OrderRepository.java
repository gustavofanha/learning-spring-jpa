package com.fanhagustavo.learning.repositories;

import com.fanhagustavo.learning.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
