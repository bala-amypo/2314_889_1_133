package com.example.demo.controller;

import com.example.demo.dto.AuthRequestDto;
import com.example.demo.dto.RegisterRequestDto;
import com.example.demo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody AuthRequestDto dto) {
        String token = authService.login(dto);
        return Map.of("token", token);
    }

    @PostMapping("/register")
    public void register(@RequestBody RegisterRequestDto dto) {
        authService.register(dto);
    }
}
