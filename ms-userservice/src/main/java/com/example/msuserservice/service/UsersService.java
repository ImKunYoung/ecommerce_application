package com.example.msuserservice.service;

import com.example.msuserservice.dto.UserDto;
import com.example.msuserservice.entity.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UsersService extends UserDetailsService {
    UserDto createUser(UserDto userDto);
    UserDto getUserByUserId(String userId);
    Iterable<UserEntity> getUserByAll();

}
