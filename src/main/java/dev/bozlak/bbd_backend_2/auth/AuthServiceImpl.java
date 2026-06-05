package dev.bozlak.bbd_backend_2.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtService jwtService;
    private final UserServiceForAuthModule userServiceForAuthModule;

    @Override
    public AuthResponseDto login(LoginRequestDto loginRequestDto) {
        final String userCode = loginRequestDto.getUserCode();

        this.authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userCode, loginRequestDto.getPassword())
        );

        UserDetails userDetails = this.userDetailsService.loadUserByUsername(userCode);

        Integer userId = this.userServiceForAuthModule.getUserIdByUserCode(userCode);
        Map<String, Object> extraClaims = new HashMap<>(1);
        extraClaims.put("userId", userId);
        String token = this.jwtService.generateToken(extraClaims, userDetails);

        return new AuthResponseDto(token);
    }
}
