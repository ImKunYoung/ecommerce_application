package com.example.msuserservice.service;

import com.example.msuserservice.dto.UserDto;

import java.util.UUID;

public class UsersServiceImpl implements UsersService {

    @Override
    public UserDto createUser(UserDto userDto) {
        userDto.setUserId(UUID.randomUUID().toString());
        return null;
    }

}
