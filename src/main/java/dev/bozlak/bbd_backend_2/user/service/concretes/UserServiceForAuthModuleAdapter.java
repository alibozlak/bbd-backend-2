package dev.bozlak.bbd_backend_2.user.service.concretes;

import dev.bozlak.bbd_backend_2.auth.UserDtoForAuthModule;
import dev.bozlak.bbd_backend_2.auth.UserServiceForAuthModule;
import dev.bozlak.bbd_backend_2.user.mappers.UserMapperForAuthModule;
import dev.bozlak.bbd_backend_2.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceForAuthModuleAdapter implements UserServiceForAuthModule {

    private final UserService userService;
    private final UserMapperForAuthModule userMapperForAuthModule;

    @Override
    public UserDtoForAuthModule getUserDtoForAuthModule(String userCode) {
        dev.bozlak.bbd_backend_2.user.dtos.UserDtoForAuthModule userDtoInUserModule
                = this.userService.getUserDtoForAuthModule(userCode);

        return this.userMapperForAuthModule.toAuthModuleFromUserModule(userDtoInUserModule);
    }

    @Override
    public Integer getUserIdByUserCode(String userCode) {
        return this.userService.getUserIdByUserCode(userCode);
    }
}
