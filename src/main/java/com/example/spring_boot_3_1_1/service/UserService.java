package com.example.spring_boot_3_1_1.service;

import com.example.spring_boot_3_1_1.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(long id);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(long id);
}
