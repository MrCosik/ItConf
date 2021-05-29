package pl.staz.ItConf.controller;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.staz.ItConf.exception.UserAlreadyExistsException;
import pl.staz.ItConf.model.User;
import pl.staz.ItConf.model.dto.UserDto;
import pl.staz.ItConf.service.UserService;

import java.net.http.HttpResponse;

@RestController
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody UserDto userDto){
        User savedUser;
        if(userService.findUserByUsername(userDto.getUsername()) == null) {
             savedUser = userService.saveUser(userDto);
        }else {
            throw new UserAlreadyExistsException("User already exists");
        }
        return new ResponseEntity<>(UserDto.from(savedUser), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HttpResponse> login(){
        return null;
    }
}
