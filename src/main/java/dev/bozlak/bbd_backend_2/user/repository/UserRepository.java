package dev.bozlak.bbd_backend_2.user.repository;

import dev.bozlak.bbd_backend_2.user.dtos.UserDtoForAuthModule;

public interface UserRepository {

    UserDtoForAuthModule getUserDtoForAuthModule(String userCode);
    Integer getUserIdByUserCode(String userCode);
    Boolean isUserABbdTracker(Integer userId);
}
