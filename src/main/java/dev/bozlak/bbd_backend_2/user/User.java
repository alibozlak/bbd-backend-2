package dev.bozlak.bbd_backend_2.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Integer userId;
    private String userCode;
    private String password;
    private Integer storeId;
    private Boolean isAdmin;
    private Boolean isActive;
    private Boolean isBbdTracker;
}
