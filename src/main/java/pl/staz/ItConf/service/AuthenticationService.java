package pl.staz.ItConf.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import pl.staz.ItConf.config.UserSession;
import pl.staz.ItConf.exception.UserAlreadyLoggedException;
import pl.staz.ItConf.exception.UserDoesntExistException;
import pl.staz.ItConf.model.User;
import pl.staz.ItConf.model.dto.UserDto;
import pl.staz.ItConf.repository.UserRepository;

@Component
public class AuthenticationService {

    final UserSession userSession;
    final UserRepository userRepository;

    public AuthenticationService(UserSession userSession, UserRepository userRepository) {
        this.userSession = userSession;
        this.userRepository = userRepository;
    }

    public boolean login(UserDto userDto) {
        User potentialUser = userRepository.findUserByUsername(userDto.getUsername());

        if (!userSession.isLoggedIn()) {
            if(potentialUser != null) {
                if (potentialUser.getUsername().equals(userDto.getUsername()) && potentialUser.getEmail().equals(userDto.getEmail())) {
                    userSession.logIn();
                    return true;
                }
            }else{
                throw new UserDoesntExistException("This username is not registered");
            }
        } else {
            throw new UserAlreadyLoggedException("User already logged");
        }
        return false;
    }


}
