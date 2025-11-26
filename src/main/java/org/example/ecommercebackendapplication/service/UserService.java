package org.example.ecommercebackendapplication.service;

import org.example.ecommercebackendapplication.dto.request.auth.RegistrationRequest;
import org.example.ecommercebackendapplication.dto.response.common.SuccessResponse;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    SuccessResponse register(RegistrationRequest request);
}
