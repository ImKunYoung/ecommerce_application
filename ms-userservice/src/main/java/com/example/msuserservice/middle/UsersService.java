package com.example.msuserservice.middle;

import com.example.msuserservice.outer.dto.UserDto;
import com.example.msuserservice.inner.service.domain.entity.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UsersService extends UserDetailsService {
    UserDto createUser(UserDto userDto);
    UserDto getUserByUserId(String userId);
    Iterable<UserEntity> getUserByAll();


    /*@Description 사용자 인증을 위한 검색 메소드*/
    UserDto getUserDetailsByEmail(String email);


    void deleteUser(String userId);


    Object getUserCount();
}
