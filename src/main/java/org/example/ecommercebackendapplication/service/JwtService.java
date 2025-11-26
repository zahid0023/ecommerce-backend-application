package org.example.ecommercebackendapplication.service;

import org.springframework.security.core.Authentication;

public interface JwtService {
    String generateToken(Authentication authentication);

    String extractUsername(String token);

    boolean isTokenValid(String token, String username);

    Long extractUserId(String token);
}
