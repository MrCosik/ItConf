package pl.staz.ItConf.exception;

public class UserAlreadyAttendsThisLecture extends RuntimeException{

    public UserAlreadyAttendsThisLecture(String message) {
        super(message);
    }

    public UserAlreadyAttendsThisLecture(String message, Throwable cause) {
        super(message, cause);
    }
}

