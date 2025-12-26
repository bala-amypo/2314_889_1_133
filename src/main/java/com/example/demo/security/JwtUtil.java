package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {
    private static final String SECRET =
            "mysecretkeymysecretkeymysecretkeymysecretkeymysecretkey1234";
    private static final long EXPIRATION = 1000 * 60 * 60; // 1 hour

    private static final Key KEY = Keys.hmacShaKeyFor(SECRET.getBytes());
    public static String generateToken(String username) {
        return generateToken(new HashMap<>(), username);
    }

    public static String generateToken(Map<String, Object> claims, String username) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(KEY, SignatureAlgorithm.HS256)
                .compact();
    }



    public static String extractUsername(String token) {
        return getAllClaims(token).getSubject();
    }
    public static String getUsername(String token) {
        return extractUsername(token);
    }

        public static boolean isTokenValid(String token, String username) {
        String extractedUsername = extractUsername(token);
        return extractedUsername.equals(username) && !isTokenExpired(token);
    }

    private static boolean isTokenExpired(String token) {
        Date expiration = getAllClaims(token).getExpiration();
        return expiration.before(new Date());
    }


    public static long getExpirationMillis() {
        return EXPIRATION;
    }

    

    private static Claims getAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
