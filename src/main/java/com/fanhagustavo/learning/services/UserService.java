package com.fanhagustavo.learning.services;

import com.fanhagustavo.learning.entities.User;
import com.fanhagustavo.learning.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public Optional<User> findById(Long id) {
        return repository.findById(id);
    }

    public User insert(User newUser) {
        return repository.save(newUser);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public User update(Long id, User u) {
        User entity = repository.getReferenceById(id);
        updateData(entity, u);
        return repository.save(entity);
    }

    private void updateData(User entity, User u) {
        entity.setName(u.getName());
        entity.setEmail(u.getEmail());
        entity.setPhone(u.getPhone());
    }
}
