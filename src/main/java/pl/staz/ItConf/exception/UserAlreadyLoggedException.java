package pl.staz.ItConf.exception;

public class UserAlreadyLoggedException extends RuntimeException{

    public UserAlreadyLoggedException(String message) {
        super(message);
    }

    public UserAlreadyLoggedException(String message, Throwable cause) {
        super(message, cause);
    }
}

