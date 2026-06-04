package dev.bozlak.bbd_backend_2.auth;

public interface UserServiceForAuthModule {

    UserDtoForAuthModule getUserDtoForAuthModule(String userCode);
    Integer getUserIdByUserCode(String userCode);
}
