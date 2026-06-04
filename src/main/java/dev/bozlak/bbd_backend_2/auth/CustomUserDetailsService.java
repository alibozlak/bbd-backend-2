package dev.bozlak.bbd_backend_2.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService  implements UserDetailsService {

    private final UserServiceForAuthModule userServiceForAuthModule;

    @Override
    public UserDetails loadUserByUsername(String userCode) throws UsernameNotFoundException {
        UserDtoForAuthModule userDtoForAuthModule
                = this.userServiceForAuthModule.getUserDtoForAuthModule(userCode);

        return User.builder()
                .username(userDtoForAuthModule.userCode())
                .password(userDtoForAuthModule.hashedPassword())
                .build();
    }
}
