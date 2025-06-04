package com.example.userservice.service;

import com.example.userservice.model.User;


import java.util.List;

public interface UserService {
    User createUser(User user);

    User getUserById(Long id);

    User updateUser(Long id, User user);

    List<User> getAllUsers();

    User addUser(User user);

    void deleteUser(Long id);
}
