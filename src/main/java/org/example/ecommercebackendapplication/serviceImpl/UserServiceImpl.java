package org.example.ecommercebackendapplication.serviceImpl;

import lombok.extern.slf4j.Slf4j;
import org.example.ecommercebackendapplication.dto.request.auth.RegistrationRequest;
import org.example.ecommercebackendapplication.dto.response.common.SuccessResponse;
import org.example.ecommercebackendapplication.model.dto.auth.CustomUserDetails;
import org.example.ecommercebackendapplication.model.entity.UserEntity;
import org.example.ecommercebackendapplication.model.mapper.auth.UserMapper;
import org.example.ecommercebackendapplication.repository.UserRepository;
import org.example.ecommercebackendapplication.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public SuccessResponse register(RegistrationRequest request) {
        UserEntity userEntity = UserMapper.fromRequest(request, passwordEncoder);
        userRepository.save(userEntity);
        return new SuccessResponse(true);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        return new CustomUserDetails(
                userEntity.getId(),
                userEntity.getUsername(),
                userEntity.getPassword(),
                List.of()
        );
    }

    @Override
    public UserEntity getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
