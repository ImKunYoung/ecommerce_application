package com.example.msuserservice.outer.controller;

import com.example.msuserservice.inner.service.domain.entity.UserEntity;
import com.example.msuserservice.inner.service.domain.vo.RequestUser;
import com.example.msuserservice.inner.service.domain.vo.ResponseUser;
import com.example.msuserservice.outer.dto.UserDto;
import com.example.msuserservice.middle.UsersService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class UsersController {

    private final Environment env;

    private final UsersService usersService;


    /*
    @Description 사용자 정보 등록
    */
    @PostMapping("/users")
    public ResponseEntity<ResponseUser> createUser(@RequestBody RequestUser user) {

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserDto userDto = modelMapper.map(user, UserDto.class);
        usersService.createUser(userDto);

        ResponseUser responseUser = modelMapper.map(userDto, ResponseUser.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseUser);

    }


    /*
    @Description 전체 사용자 조회
    */
    @GetMapping("/users")
    public ResponseEntity<List<ResponseUser>> getUsers() {

        Iterable<UserEntity> userList = usersService.getUserByAll();

        List<ResponseUser> result = new ArrayList<>();

        userList.forEach(v -> result.add(new ModelMapper().map(v, ResponseUser.class)));

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }


    /*
    @Description 사용자 정보, 주문내역 조회
    */
    @GetMapping(value = "/users/{userId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ResponseUser> getUser(@PathVariable("userId") String userId) {

        UserDto userDto = usersService.getUserByUserId(userId);

        ResponseUser result = new ModelMapper().map(userDto, ResponseUser.class);

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }


    /*
    @Description 작동 상태 확인
    */
    @GetMapping("/health_check")
    public String status(HttpServletRequest request) {

        return String.format("It's Working in User Service, port(local.server.port)=" + env.getProperty("local.server.port")
                + ", port(server.port)=" + env.getProperty("server.port")
                + ", token_secret=" + env.getProperty("token.secret")
                + ", token_expiration_time=" + env.getProperty("token.expiration_time")
        );


//        return String.format("It's Working in User Service on PORT %s", request.getServerPort());
    }


    /*
   @Description 유저 삭제
   */
    @DeleteMapping("/users/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable("userId") String userId) {

        usersService.deleteUser(userId);

        return ResponseEntity.noContent().build();
    }


    // 조회 카운트
    @GetMapping("/users/count")
    public ResponseEntity<Object> getUserCount() {

        return ResponseEntity.status(HttpStatus.OK).body(usersService.getUserCount());
    }
    
    /*
    @Description 환영 메세지
    */
    @GetMapping("/welcome")
    public String welcome() {
        return env.getProperty("greeting.message");
    }

}
