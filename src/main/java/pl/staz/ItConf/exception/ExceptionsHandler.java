package pl.staz.ItConf.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(value = {UserAlreadyExistsException.class})
    public ResponseEntity<Object> handleAlreadyLoggedException(UserAlreadyExistsException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {UserNotLoggedException.class})
    public ResponseEntity<Object> handleUserNotLoggedException(UserNotLoggedException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {UserAlreadyLoggedException.class})
    public ResponseEntity<Object> handleUserAlreadyLoggedException(UserAlreadyLoggedException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {UserDoesntExistException.class})
    public ResponseEntity<Object> handleUserDoesntExistException(UserDoesntExistException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {UserAlreadyAttendsThisLecture.class})
    public ResponseEntity<Object> handleUserAlreadyAttendsThisLecture(UserAlreadyAttendsThisLecture e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {UserAlreadyAttendsException.class})
    public ResponseEntity<Object> handleUserAlreadyAttendsException(UserAlreadyAttendsException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(value = {NotEnoughSeatsException.class})
    public ResponseEntity<Object> handleNotEnoughSeatsException(NotEnoughSeatsException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {UserDoesntAttendAnyLecture.class})
    public ResponseEntity<Object> handleUserDoesntAttendAnyLecture(UserDoesntAttendAnyLecture e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
