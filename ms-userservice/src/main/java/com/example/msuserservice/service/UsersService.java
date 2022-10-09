package com.example.msuserservice.service;

import com.example.msuserservice.dto.UserDto;
import com.example.msuserservice.entity.UserEntity;

public interface UsersService{
    UserDto createUser(UserDto userDto);
    UserDto getUserByUserId(String userId);
    Iterable<UserEntity> getUserByAll();

}
