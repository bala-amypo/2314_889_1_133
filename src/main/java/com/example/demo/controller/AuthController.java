package com.example.demo.controller;

import com.example.demo.dto.AuthRequestDto;
import com.example.demo.dto.AuthResponseDto;
import com.example.demo.dto.RegisterRequestDto;
import com.example.demo.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody RegisterRequestDto dto) {
        service.register(dto);
    }

    @PostMapping("/login")
    public AuthResponseDto login(@RequestBody AuthRequestDto dto) {
        return service.login(dto);
    }
    @PostMapping("/init-admin")
public ResponseEntity<?> initAdminUser() {

    // check if admin already exists
    Optional<UserAccount> existing =
            userAccountRepository.findByEmail("admin@example.com");

    if (existing.isEmpty()) {

        UserAccount admin = new UserAccount();
        admin.setEmail("admin@example.com");
        admin.setPassword(passwordEncoder.encode("admin123"));
        admin.setRole("ADMIN");

        userAccountRepository.save(admin);
    }

    // generate token for admin
    UserAccount adminUser =
            userAccountRepository.findByEmail("admin@example.com").get();

    String token = jwtUtil.generateToken(adminUser);

    Map<String,Object> body = new HashMap<>();
    body.put("token", token);

    return ResponseEntity.ok(body);
}

}