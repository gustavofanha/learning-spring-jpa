package com.fanhagustavo.learning.repositories;

import com.fanhagustavo.learning.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
