package com.example.demo.service.impl;

import com.example.demo.dto.AuthRequestDto;
import com.example.demo.dto.AuthResponseDto;
import com.example.demo.dto.RegisterRequestDto;
import com.example.demo.entity.UserAccount;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.AuthService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserAccountRepository repo;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public AuthServiceImpl(UserAccountRepository repo) {
        this.repo = repo;
    }

    @Override
    public void register(RegisterRequestDto dto) {

        repo.findByEmail(dto.getEmail())
                .ifPresent(u -> {
                    throw new BadRequestException("Email already registered");
                });

        UserAccount user = new UserAccount();
        user.setEmail(dto.getEmail());
        user.setPassword(encoder.encode(dto.getPassword()));
        user.setFullName(dto.getFullName());
        user.setRole("USER");

        repo.save(user);
    }

    @Override
    public AuthResponseDto login(AuthRequestDto dto) {

        UserAccount user = repo.findByEmail(dto.getEmail())
                .orElseThrow(() -> new BadRequestException("Invalid credentials"));

        if (!encoder.matches(dto.getPassword(), user.getPassword())) {
            throw new BadRequestException("Invalid credentials");
        }

        String token = JwtUtil.generateToken(user.getEmail());
        return new AuthResponseDto(token);
    }
}