package com.fanhagustavo.learning.services;

import com.fanhagustavo.learning.entities.Category;
import com.fanhagustavo.learning.entities.User;
import com.fanhagustavo.learning.repositories.CategoryRepository;
import com.fanhagustavo.learning.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Optional<Category> findById(Long id) {
        return repository.findById(id);
    }
}
