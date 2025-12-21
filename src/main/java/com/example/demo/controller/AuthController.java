package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.AuthService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService userService;

    public AuthController(AuthService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public UserAccount register(@RequestBody UserAccount user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public UserAccount login(@RequestBody UserAccount user) {
        return userService.login(user.getEmail(), user.getPassword());
    }

    @GetMapping("/{id}")
    public UserAccount getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping
    public List<UserAccount> getAllUsers() {
        return userService.getAllUsers();
    }
}
