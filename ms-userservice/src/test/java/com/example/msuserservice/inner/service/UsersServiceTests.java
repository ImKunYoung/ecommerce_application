package com.example.msuserservice.inner.service;

import com.example.msuserservice.middle.UsersService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RequiredArgsConstructor
public class UsersServiceTests {

    private final UsersService usersService;

    @Test
    private void getUsersByUserId() {
        /*TODO: -Feign 잘 되는지 확인*/

    }


}
