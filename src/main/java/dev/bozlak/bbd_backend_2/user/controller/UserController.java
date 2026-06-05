package dev.bozlak.bbd_backend_2.user.controller;

import dev.bozlak.bbd_backend_2.user.dtos.response.IsUserABbdTracker;
import dev.bozlak.bbd_backend_2.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users/v1")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/is-user-a-bbd-tracker")
    public ResponseEntity<IsUserABbdTracker> getIsUserABbdTracker(@RequestHeader("Authorization") String authHeader){
        IsUserABbdTracker isUserABbdTracker = this.userService.getIsUserBbdTrackerByToken(authHeader);
        return ResponseEntity.ok(isUserABbdTracker);
    }
}
