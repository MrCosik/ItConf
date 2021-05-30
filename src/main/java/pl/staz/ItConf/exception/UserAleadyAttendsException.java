package pl.staz.ItConf.exception;

public class UserAleadyAttendsException extends RuntimeException{

    public UserAleadyAttendsException(String message) {
        super(message);
    }

    public UserAleadyAttendsException(String message, Throwable cause) {
        super(message, cause);
    }
}

