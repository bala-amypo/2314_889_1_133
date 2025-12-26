package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtUtil {

    @Value("${jwt.secret:my-secret-key-12345678901234567890}")
    private String secret;

    @Value("${jwt.expiration:86400000}") // 1 day default
    private long expirationMillis;

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(secret.getBytes());
    }

    // -----------------------------------------------------
    // Token Creation
    // -----------------------------------------------------
    public String generateToken(Map<String, Object> claims, String username) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationMillis))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    // -----------------------------------------------------
    // Extract Claims / Username / Expiration
    // -----------------------------------------------------
    public String getUsername(String token) {
        return getClaim(token, Claims::getSubject);
    }

    public Date getExpirationDate(String token) {
        return getClaim(token, Claims::getExpiration);
    }

    public <T> T getClaim(String token, Function<Claims, T> extractor) {
        Claims claims = extractAllClaims(token);
        return extractor.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // -----------------------------------------------------
    // Validation
    // -----------------------------------------------------
    public boolean isTokenExpired(String token) {
        return getExpirationDate(token).before(new Date());
    }

    public boolean isTokenValid(String token, String expectedUsername) {
        String username = getUsername(token);
        return username.equals(expectedUsername) && !isTokenExpired(token);
    }

    // -----------------------------------------------------
    // Configuration Helpers for Tests
    // -----------------------------------------------------
    public long getExpirationMillis() {
        return expirationMillis;
    }

    public long getRemainingValidity(String token) {
        return getExpirationDate(token).getTime() - System.currentTimeMillis();
    }

    public Date getIssuedAt(String token) {
        return getClaim(token, Claims::getIssuedAt);
    }
}
