package org.example.ecommercebackendapplication.serviceImpl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.example.ecommercebackendapplication.model.dto.auth.CustomUserDetails;
import org.example.ecommercebackendapplication.service.JwtService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
@Slf4j
public class JwtServiceImpl implements JwtService {

    private SecretKey SIGNING_KEY;

    @PostConstruct
    public void init() {
        String SECRET_KEY = "v0Rp4Wdzf3zK4PVj7N91+n4FBjkD6SacKKctMzNg5Bw=";
        this.SIGNING_KEY = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public String generateToken(Authentication authentication) {

        CustomUserDetails user = (CustomUserDetails) authentication.getPrincipal();
        Long userId = user.getId();

        Date now = new Date();
        long EXPIRATION_MS = 24 * 60 * 60 * 1000;

        return Jwts.builder()
                .subject(user.getUsername())
                .claim("user_id", userId)     // 👈 ADDED
                .issuedAt(now)
                .expiration(new Date(now.getTime() + EXPIRATION_MS))
                .signWith(SIGNING_KEY)
                .compact();
    }

    @Override
    public String extractUsername(String token) {
        Claims claims = Jwts.parser().verifyWith(SIGNING_KEY).build()
                .parseSignedClaims(token).getPayload();

        return claims.getSubject();
    }

    @Override
    public Long extractUserId(String token) {
        Claims claims = Jwts.parser().verifyWith(SIGNING_KEY).build()
                .parseSignedClaims(token).getPayload();

        return claims.get("user_id", Long.class);
    }

    @Override
    public boolean isTokenValid(String token, String username) {
        try {
            Claims claims = Jwts.parser().verifyWith(SIGNING_KEY).build()
                    .parseSignedClaims(token).getPayload();

            boolean notExpired = claims.getExpiration().after(new Date());
            return username.equals(claims.getSubject()) && notExpired;
        } catch (Exception e) {
            log.warn("JWT validation failed: {}", e.getMessage());
            return false;
        }
    }
}