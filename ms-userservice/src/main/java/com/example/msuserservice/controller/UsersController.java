package com.example.msuserservice.controller;

import com.example.msuserservice.dto.RequestUser;
import com.example.msuserservice.dto.ResponseUser;
import com.example.msuserservice.dto.UserDto;
import com.example.msuserservice.service.UsersService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class UsersController {

    private Environment env;

    @Autowired
    private UsersService usersService;

    @GetMapping("/health_check")
    public String status() {
        return "It's Working in User Service";
    }

    @GetMapping("welcome")
    public String welcome() {
        return env.getProperty("greeting.message");
    }

    @PostMapping("/users")
    public ResponseEntity<ResponseUser> createUser(@RequestBody RequestUser user) {

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserDto userDto = modelMapper.map(user, UserDto.class);
        usersService.createUser(userDto);

        ResponseUser responseUser = modelMapper.map(userDto, ResponseUser.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseUser);

    }

}
