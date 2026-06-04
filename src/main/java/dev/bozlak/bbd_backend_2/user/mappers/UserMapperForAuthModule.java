package dev.bozlak.bbd_backend_2.user.mappers;

import dev.bozlak.bbd_backend_2.auth.UserDtoForAuthModule;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapperForAuthModule {

    UserDtoForAuthModule toAuthModuleFromUserModule(
            dev.bozlak.bbd_backend_2.user.dtos.UserDtoForAuthModule userDtoForAuthModuleInUserModule
    );

}
