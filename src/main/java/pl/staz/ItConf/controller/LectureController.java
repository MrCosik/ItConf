package pl.staz.ItConf.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.staz.ItConf.config.UserSession;
import pl.staz.ItConf.exception.UserNotLoggedException;
import pl.staz.ItConf.model.Lecture;
import pl.staz.ItConf.repository.LectureRepository;
import pl.staz.ItConf.service.LectureService;

@RestController
public class LectureController {

    UserSession userSession;
    LectureService lectureService;

    public LectureController(UserSession userSession, LectureService lectureService) {
        this.userSession = userSession;
        this.lectureService = lectureService;
    }

    @GetMapping("/lecture")
    public ResponseEntity<HttpStatus> signInForLecture(@RequestParam Long topicId, @RequestParam Long lectureId){
    if(!userSession.isLoggedIn())
        throw new UserNotLoggedException("You need to login");

    lectureService.signUpForLecture(topicId, lectureId);


        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


}
