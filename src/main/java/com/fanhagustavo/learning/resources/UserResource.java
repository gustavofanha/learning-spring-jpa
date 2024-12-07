package com.fanhagustavo.learning.resources;

import com.fanhagustavo.learning.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll() {
        User u = new User(1L, "Joao", "joao@mail.com", "459999545", "456123");
        return ResponseEntity.ok().body(u);
    }
}
