package dev.bozlak.bbd_backend_2.auth;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestDto {

    @NotNull(message = "Username must be not null!!")
    @NotBlank(message = "Username must be not blank!!")
    private String userCode;

    @NotNull(message = "Password must be not null!!")
    @NotBlank(message = "Password must be not blank!!")
    private String password;
}