package pl.staz.ItConf.controller;

import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.staz.ItConf.model.User;
import pl.staz.ItConf.model.dto.UserDto;

import java.net.http.HttpResponse;

@RestController
public class UserController {

    @PostMapping
    public ResponseEntity<UserDto> register(@RequestBody UserDto userDto ){
        return null;
    }

    @PostMapping
    public ResponseEntity<HttpResponse> login(){
        return null;
    }
}
