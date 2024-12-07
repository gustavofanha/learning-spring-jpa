package com.fanhagustavo.learning.repositories;

import com.fanhagustavo.learning.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
