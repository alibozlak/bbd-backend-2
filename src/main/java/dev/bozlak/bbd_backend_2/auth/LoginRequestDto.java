package dev.bozlak.bbd_backend_2.auth;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoginRequestDto {

    @NotNull(message = "Username must be not null!!")
    @NotBlank(message = "Username must be not blank!!")
    private String userCode;

    @NotNull(message = "Password must be not null!!")
    @NotBlank(message = "Password must be not blank!!")
    private String password;
}