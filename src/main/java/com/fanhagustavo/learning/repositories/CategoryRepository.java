package com.fanhagustavo.learning.repositories;

import com.fanhagustavo.learning.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
