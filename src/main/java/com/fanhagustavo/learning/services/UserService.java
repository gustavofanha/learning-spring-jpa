package com.fanhagustavo.learning.services;

import com.fanhagustavo.learning.entities.User;
import com.fanhagustavo.learning.repositories.UserRepository;
import com.fanhagustavo.learning.services.exceptions.DatabaseException;
import com.fanhagustavo.learning.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User newUser) {
        return repository.save(newUser);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public User update(Long id, User u) {
        try {
            User entity = repository.getReferenceById(id);
            updateData(entity, u);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(User entity, User u) {
        entity.setName(u.getName());
        entity.setEmail(u.getEmail());
        entity.setPhone(u.getPhone());
    }
}
