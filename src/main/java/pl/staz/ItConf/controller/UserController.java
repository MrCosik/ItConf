package pl.staz.ItConf.controller;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import pl.staz.ItConf.config.UserSession;
import pl.staz.ItConf.exception.UserAlreadyExistsException;
import pl.staz.ItConf.exception.UserNotLoggedException;
import pl.staz.ItConf.model.User;
import pl.staz.ItConf.model.dto.UserDto;
import pl.staz.ItConf.model.dto.UserEmailDto;
import pl.staz.ItConf.service.AuthenticationService;
import pl.staz.ItConf.service.UserService;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
public class UserController {
    UserService userService;
    AuthenticationService authenticationService;
    UserSession userSession;


    public UserController(UserService userService, AuthenticationService authenticationService, UserSession userSession) {
        this.userService = userService;
        this.authenticationService = authenticationService;
        this.userSession = userSession;
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody UserDto userDto) {
        User savedUser;
        if (userService.findUserByUsername(userDto.getUsername()) == null) {
            savedUser = userService.saveUser(userDto);
        } else {
            throw new UserAlreadyExistsException("User already exists");
        }
        return new ResponseEntity<>(UserDto.from(savedUser), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody UserDto userDto) {
        if (authenticationService.login(userDto))
            return new ResponseEntity<>(HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @GetMapping("/signout")
    public void logout() {
        authenticationService.logout();
//        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/registeredUsers")
    public ResponseEntity<List<UserDto>> showRegisteredUsers() {
        List<UserDto> allUsers = userService.showAllRegisteredUsers();

        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @PostMapping("/changeEmail")
    public ResponseEntity<UserDto> changeEmail(@RequestBody UserEmailDto userEmailDto) {
        if (!userSession.isLoggedIn())
            throw new UserNotLoggedException("You are not logged in");

        UserDto changedUser = userService.changeEmail(userEmailDto);

        return new ResponseEntity<>(changedUser, HttpStatus.OK);
    }


}
