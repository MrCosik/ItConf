package pl.staz.ItConf.service;

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

        //check to see if user is not already logged in and then check if the credentials that user tries to login with
        //are present in the DB, if all true service returns true and controller send HttpRequest.OK
        //and username and email of person that tries to login, to the frontend
        if (!userSession.isLoggedIn()) {
            if (potentialUser != null) {
                if (potentialUser.getUsername().equals(userDto.getUsername()) && potentialUser.getEmail().equals(userDto.getEmail())) {
                    userSession.logIn(potentialUser);
                    System.out.println("Log in");
                    return true;
                }
            } else {
                throw new UserDoesntExistException("This username is not registered");
            }
        } else {
            throw new UserAlreadyLoggedException("User already logged");
        }
        return false;
    }

    public void logout() {
        if (!userSession.isLoggedIn())
            throw new UserAlreadyLoggedException("User already logged");

        userSession.logOut();
    }

}
