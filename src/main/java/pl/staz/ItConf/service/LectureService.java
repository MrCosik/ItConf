package pl.staz.ItConf.service;

import org.springframework.stereotype.Service;
import pl.staz.ItConf.config.UserSession;
import pl.staz.ItConf.exception.NotEnoughSeatsException;
import pl.staz.ItConf.exception.UserAlreadyAttendsException;
import pl.staz.ItConf.exception.UserAlreadyAttendsThisLecture;
import pl.staz.ItConf.model.Lecture;
import pl.staz.ItConf.model.TopicsLecture;
import pl.staz.ItConf.model.User;
import pl.staz.ItConf.repository.UserRepository;

import java.util.Arrays;
import java.util.List;

@Service
public class LectureService {

    UserSession userSession;
    UserRepository userRepository;

    public LectureService(UserSession userSession, UserRepository userRepository) {
        this.userSession = userSession;
        this.userRepository = userRepository;
    }

    List<TopicsLecture> topic1 = Arrays.asList(
            new TopicsLecture(1L, 1L, 5),
            new TopicsLecture(1L, 2L, 0),
            new TopicsLecture(1L, 3L, 0)
    );

    List<TopicsLecture> topic2 = Arrays.asList(
            new TopicsLecture(2L, 1L, 0),
            new TopicsLecture(2L, 2L, 0),
            new TopicsLecture(2L, 3L, 0)
    );

    List<TopicsLecture> topic3 = Arrays.asList(
            new TopicsLecture(3L, 1L, 0),
            new TopicsLecture(3L, 2L, 0),
            new TopicsLecture(3L, 3L, 0)
    );


    public void signUpForLecture(Long topicId, Long lectureId) {
        User loggedUser = userRepository.findUserByUsername(userSession.getUsername());
        Lecture lectureToAdd = new Lecture();
        System.out.println(loggedUser.getAttendedLectures());



        for (Lecture lecture : loggedUser.getAttendedLectures()) {
            if(lecture.getLectureNumber().equals(lectureId))
                throw new UserAlreadyAttendsException("User already attends lecture at this time");
            if (lecture.getLectureNumber().equals(lectureId) && lecture.getTopicNumber().equals(topicId))
                throw new UserAlreadyAttendsThisLecture("User already attends this lecture");

        }
            switch (topicId.intValue()) {
                case 1:

                    TopicsLecture lecture1 = topic1.get(lectureId.intValue() - 1);
                    lectureToAdd.setLectureNumber(lecture1.getLectureNumber());
                    lectureToAdd.setTopicNumber(lecture1.getTopicId());
                    lectureToAdd.setAppUserId(loggedUser.getId());
                    if(lecture1.getNumberOfAttendees() == 5)
                        throw new NotEnoughSeatsException("Lecture is full");
                    lectureToAdd.setAttendees(lecture1.getNumberOfAttendees() + 1);
                    loggedUser.addLecture(lectureToAdd);
                    userRepository.save(loggedUser);
                    break;
                case 2:
                    TopicsLecture lecture2 = topic2.get(lectureId.intValue());
                    lectureToAdd.setLectureNumber(lecture2.getLectureNumber());
                    lectureToAdd.setTopicNumber(lecture2.getTopicId());
                    lectureToAdd.setAppUserId(loggedUser.getId());
                    if(lecture2.getNumberOfAttendees() == 5)
                        throw new NotEnoughSeatsException("Lecture is full");
                    lectureToAdd.setAttendees(lecture2.getNumberOfAttendees() + 1);
                    loggedUser.addLecture(lectureToAdd);
                    userRepository.save(loggedUser);
                    break;
                case 3:
                    TopicsLecture lecture3 = topic3.get(lectureId.intValue());
                    lectureToAdd.setLectureNumber(lecture3.getLectureNumber());
                    lectureToAdd.setTopicNumber(lecture3.getTopicId());
                    lectureToAdd.setAppUserId(loggedUser.getId());
                    if(lecture3.getNumberOfAttendees() == 5)
                        throw new NotEnoughSeatsException("Lecture is full");
                    lectureToAdd.setAttendees(lecture3.getNumberOfAttendees() + 1);
                    loggedUser.addLecture(lectureToAdd);
                    userRepository.save(loggedUser);
                    break;

            }

    }


}
