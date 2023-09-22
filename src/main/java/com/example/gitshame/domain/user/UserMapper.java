package com.example.gitshame.domain.user;

import com.example.gitshame.business.account.dto.AccountRequest;
import com.example.gitshame.business.login.dto.LoginResponse;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    @Mapping(source = "id", target = "userId")
    @Mapping(source = "role.name", target = "roleName")
    LoginResponse toLoginResponse(User user);



    @Mapping(constant = "A", target = "status")
    User toUser(AccountRequest request);
}