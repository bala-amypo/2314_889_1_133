package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<UserAccount> register(@RequestBody UserAccount user) {
        UserAccount savedUser = authService.register(user);
        return ResponseEntity.ok(savedUser);
    }

 
    @PostMapping("/login")
    public ResponseEntity<UserAccount> login(@RequestParam String email, @RequestParam String password) {
        UserAccount user = authService.login(email, password);
        return ResponseEntity.ok(user);
    }
}
