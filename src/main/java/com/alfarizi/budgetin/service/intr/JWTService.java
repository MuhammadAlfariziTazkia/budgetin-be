package com.alfarizi.budgetin.service.intr;

public interface JWTService {

    String generateToken(String email);

    String extractUsername(String token);
}
