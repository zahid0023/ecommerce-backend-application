package org.example.ecommercebackendapplication.model.mapper.auth;

import lombok.experimental.UtilityClass;
import org.example.ecommercebackendapplication.dto.request.auth.RegistrationRequest;
import org.example.ecommercebackendapplication.model.entity.UserEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

@UtilityClass
public class UserMapper {
    public static UserEntity fromRequest(RegistrationRequest request, PasswordEncoder passwordEncoder) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(request.getUserName());
        userEntity.setPassword(passwordEncoder.encode(request.getPassword()));
        return userEntity;
    }
}
