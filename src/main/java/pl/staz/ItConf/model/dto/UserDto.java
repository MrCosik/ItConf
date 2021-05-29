package pl.staz.ItConf.model.dto;

import pl.staz.ItConf.model.User;

import javax.persistence.Column;
import javax.persistence.Id;


public class UserDto {

    private String username;
    private String email;

    public UserDto(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public UserDto() {
    }


    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public static  UserDto from(User user){
        UserDto userDto = new UserDto();
        userDto.username = user.getUsername();
        userDto.email = user.getEmail();
        return userDto;

    }


}
