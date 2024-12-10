package com.fanhagustavo.learning.repositories;

import com.fanhagustavo.learning.entities.Category;
import com.fanhagustavo.learning.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
