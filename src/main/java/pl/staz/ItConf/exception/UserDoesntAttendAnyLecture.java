package pl.staz.ItConf.exception;

public class UserDoesntAttendAnyLecture extends RuntimeException{

    public UserDoesntAttendAnyLecture(String message) {
        super(message);
    }

    public UserDoesntAttendAnyLecture(String message, Throwable cause) {
        super(message, cause);
    }
}

