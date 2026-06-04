package dev.bozlak.bbd_backend_2.user.service.concretes;

import dev.bozlak.bbd_backend_2.user.dtos.UserDtoForAuthModule;
import dev.bozlak.bbd_backend_2.user.repository.UserRepository;
import dev.bozlak.bbd_backend_2.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDtoForAuthModule getUserDtoForAuthModule(String userCode) {
        return this.userRepository.getUserDtoForAuthModule(userCode);
    }

    @Override
    public Integer getUserIdByUserCode(String userCode) {
        return this.userRepository.getUserIdByUserCode(userCode);
    }
}
