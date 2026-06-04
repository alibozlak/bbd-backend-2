package dev.bozlak.bbd_backend_2.auth;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;

public interface JwtService {

    String generateToken(Map<String, Object> extraClaims, UserDetails userDetails);
    Integer getUserId(String token);
    boolean isTokenValid(String token, UserDetails userDetails);
    String getUserName(String token);
}
