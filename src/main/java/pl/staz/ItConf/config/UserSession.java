package pl.staz.ItConf.config;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import pl.staz.ItConf.model.User;

@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Component
public class UserSession {

    private boolean isLogged = false;
    private String username;

    public void logIn(User user){
        isLogged = true;
        username = user.getUsername();
    }

    public void logOut(){
        isLogged = false;
        username = null;
    }

    public boolean isLoggedIn() {
        return isLogged;
    }

    public String getUsername() {
        return username;
    }
}
