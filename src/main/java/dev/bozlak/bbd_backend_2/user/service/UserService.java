package dev.bozlak.bbd_backend_2.user.service;

import dev.bozlak.bbd_backend_2.user.dtos.UserDtoForAuthModule;
import dev.bozlak.bbd_backend_2.user.dtos.response.IsUserABbdTracker;

public interface UserService {

    UserDtoForAuthModule getUserDtoForAuthModule(String userCode);
    Integer getUserIdByUserCode(String userCode);
    IsUserABbdTracker getIsUserBbdTrackerByToken(String authHeader);
}
