package com.denisenko.springboot.service;

import com.denisenko.springboot.model.User;

import java.util.List;

public interface UserService {
    User findById(Long id);

    List<User> findAll();

    void save(User user);

    void deleteById(Long id);
}