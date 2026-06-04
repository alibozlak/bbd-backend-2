package dev.bozlak.bbd_backend_2.user.service;

import dev.bozlak.bbd_backend_2.user.dtos.UserDtoForAuthModule;

public interface UserService {

    UserDtoForAuthModule getUserDtoForAuthModule(String userCode);
    Integer getUserIdByUserCode(String userCode);
}
