package com.example.msuserservice.middle;

import com.example.msuserservice.outer.dto.UserDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
public class UsersServiceTests {

    @Autowired
    private UsersService usersService;

    @Autowired
    private UserRepository userRepository;

//
//    @BeforeAll
//    public void insert() {
//
//        IntStream.rangeClosed(1, 10).forEach(i -> {
//            UserDto userDto = UserDto.builder()
//                    .userId("test" + i)
//                    .email("test" + i + "@test.com")
//                    .name("test" + i)
//                    .pwd("test" + i)
//                    .build();
//
//            usersService.createUser(userDto);
//        });
//
//    }



    @Test
    public void deleteUser() {
        usersService.deleteUser("test1");

        userRepository.findAll().forEach(System.out::println);
    }
}
