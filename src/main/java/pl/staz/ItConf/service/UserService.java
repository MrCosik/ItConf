package pl.staz.ItConf.service;

import org.springframework.stereotype.Component;
import pl.staz.ItConf.config.UserSession;
import pl.staz.ItConf.model.User;
import pl.staz.ItConf.model.dto.UserDto;
import pl.staz.ItConf.model.dto.UserEmailDto;
import pl.staz.ItConf.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserService {

    UserRepository userRepository;
    UserSession userSession;


    public UserService(UserRepository userRepository, UserSession userSession) {
        this.userRepository = userRepository;
        this.userSession = userSession;
    }

    public User saveUser(UserDto userDto) {
        User savedUser = new User();
        savedUser.setUsername(userDto.getUsername());
        savedUser.setEmail(userDto.getEmail());
        userRepository.save(savedUser);
        return savedUser;
    }

    public User findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    public List<UserDto> showAllRegisteredUsers() {
        List<UserDto> allUsers = new ArrayList<>();

        for(User user : userRepository.findAll()){
            allUsers.add(new UserDto(user.getUsername(), user.getEmail()));
        }
        return allUsers;
    }

    public UserDto changeEmail(UserEmailDto userEmailDto) {
        User loggedUser = userRepository.findUserByUsername(userSession.getUsername());


        loggedUser.setEmail(userEmailDto.getEmail());
        userRepository.save(loggedUser);


        return new UserDto(loggedUser.getUsername(), loggedUser.getEmail());
    }
}
