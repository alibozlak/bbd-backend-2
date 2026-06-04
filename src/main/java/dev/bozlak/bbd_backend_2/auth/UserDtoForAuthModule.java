package dev.bozlak.bbd_backend_2.auth;

public record UserDtoForAuthModule(
        Integer userId,
        String userCode,
        String hashedPassword
) {
}
