package dev.bozlak.bbd_backend_2.auth;

public interface AuthService {

    AuthResponseDto login(LoginRequestDto loginRequestDto);
}
