package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.AuthService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthServiceImpl implements UserAccountService {

    private final UserAccountRepository userRepo;

    public AuthServiceImpl(UserAccountRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserAccount register(UserAccount user) {

        if (userRepo.findByEmail(user.getEmail()).isPresent()) {
            throw new BadRequestException("Email already exists");
        }
        return userRepo.save(user);
    }

    @Override
    public UserAccount login(String email, String password) {

        UserAccount user = userRepo.findByEmail(email)
                .orElseThrow(() -> new BadRequestException("Invalid credentials"));

        return user;
    }

    @Override
    public UserAccount getUserById(Long id) {
        return userRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    public List<UserAccount> getAllUsers() {
        return userRepo.findAll();
    }
}
