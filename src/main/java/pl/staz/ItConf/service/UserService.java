package pl.staz.ItConf.service;

import org.springframework.stereotype.Component;
import pl.staz.ItConf.model.User;
import pl.staz.ItConf.model.dto.UserDto;
import pl.staz.ItConf.repository.UserRepository;

@Component
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
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
}
