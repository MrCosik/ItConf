package pl.staz.ItConf.exception;

public class UserAlreadyAttendsException extends RuntimeException{

    public UserAlreadyAttendsException(String message) {
        super(message);
    }

    public UserAlreadyAttendsException(String message, Throwable cause) {
        super(message, cause);
    }
}

