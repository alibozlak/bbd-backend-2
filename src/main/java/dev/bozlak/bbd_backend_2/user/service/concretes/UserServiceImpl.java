package dev.bozlak.bbd_backend_2.user.service.concretes;

import dev.bozlak.bbd_backend_2.auth.JwtService;
import dev.bozlak.bbd_backend_2.user.dtos.UserDtoForAuthModule;
import dev.bozlak.bbd_backend_2.user.dtos.response.IsUserABbdTracker;
import dev.bozlak.bbd_backend_2.user.repository.UserRepository;
import dev.bozlak.bbd_backend_2.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final JwtService jwtService;

    @Override
    public UserDtoForAuthModule getUserDtoForAuthModule(String userCode) {
        return this.userRepository.getUserDtoForAuthModule(userCode);
    }

    @Override
    public Integer getUserIdByUserCode(String userCode) {
        return this.userRepository.getUserIdByUserCode(userCode);
    }

    @Override
    public IsUserABbdTracker getIsUserBbdTrackerByToken(String authHeader) {
        String token = authHeader.substring(7);
        Integer userId = this.jwtService.getUserId(token);

        return new IsUserABbdTracker(
                this.userRepository.isUserABbdTracker(userId)
        );
    }
}
