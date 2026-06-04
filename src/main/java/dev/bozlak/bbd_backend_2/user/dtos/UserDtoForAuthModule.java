package dev.bozlak.bbd_backend_2.user.dtos;

public record UserDtoForAuthModule(
        Integer userId,
        String userCode,
        String hashedPassword
) {
}
