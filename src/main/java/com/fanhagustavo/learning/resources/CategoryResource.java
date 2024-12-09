package com.fanhagustavo.learning.resources;

import com.fanhagustavo.learning.entities.Category;
import com.fanhagustavo.learning.entities.User;
import com.fanhagustavo.learning.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

    @Autowired
    private CategoryService service;

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        List<Category> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Category>> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }
}
