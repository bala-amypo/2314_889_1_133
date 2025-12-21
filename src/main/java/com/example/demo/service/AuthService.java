package com.example.demo.service;

import com.example.demo.entity.UserAccount;

import java.util.List;

public interface AuthService{

    UserAccount register(UserAccount user);

    UserAccount login(String email, String password);

    UserAccount getUserById(Long id);

    List<UserAccount> getAllUsers();
}
