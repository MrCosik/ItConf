package pl.staz.ItConf.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.staz.ItConf.config.UserSession;
import pl.staz.ItConf.exception.UserNotLoggedException;
import pl.staz.ItConf.model.dao.LectureDao;
import pl.staz.ItConf.service.LectureService;

import java.util.List;

@RestController
public class LectureController {

    UserSession userSession;
    LectureService lectureService;

    public LectureController(UserSession userSession, LectureService lectureService) {
        this.userSession = userSession;
        this.lectureService = lectureService;
    }

    @PostMapping("/signForLecture")
    public ResponseEntity<HttpStatus> signInForLecture(@RequestParam Long topicNumber, @RequestParam Long lectureNumber) {
        if (!userSession.isLoggedIn())
            throw new UserNotLoggedException("You need to login");

        lectureService.signUpForLecture(topicNumber, lectureNumber);


        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/conference")
    public ResponseEntity<List<LectureDao>> getListOfLectures() {
        List<LectureDao> returnList = lectureService.getListOfLectures();

        return new ResponseEntity<>(returnList, HttpStatus.OK);
    }

    @GetMapping("/usersLectures")
    public ResponseEntity<List<LectureDao>> getListOfUsersLectures() {
        List<LectureDao> returnList = lectureService.getListOfUsersLectures();

        return new ResponseEntity<>(returnList, HttpStatus.OK);
    }

    @GetMapping("/cancelLecture/{lectureNumber}")
    public void cancelUsersAttendanceToALecture(@PathVariable Long lectureNumber) {
        lectureService.cancelLecture(lectureNumber);
    }


}
