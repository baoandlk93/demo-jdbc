package com.baoandev.demojdbc.service;

import com.baoandev.demojdbc.entity.User;
import com.baoandev.demojdbc.repository.UserRepository;

import java.util.List;

public class UserService {

    private final UserRepository userRepository = new UserRepository();

    public void insertUser(String name, String email, String country) {
        userRepository.insertUser(name, email, country);
    }

    public List<User> selectUser() {
        return userRepository.selectUser();
    }
}
