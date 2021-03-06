package pl.staz.ItConf.service;

import org.springframework.stereotype.Service;
import pl.staz.ItConf.config.UserSession;
import pl.staz.ItConf.exception.*;
import pl.staz.ItConf.model.Lecture;
import pl.staz.ItConf.model.User;
import pl.staz.ItConf.model.dao.LectureDao;
import pl.staz.ItConf.repository.UserRepository;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LectureService {

    UserSession userSession;
    UserRepository userRepository;

    public LectureService(UserSession userSession, UserRepository userRepository) {
        this.userSession = userSession;
        this.userRepository = userRepository;
    }

    //plan of all the lectures, we have 3 topics, lecture with number 1 start at 10, number 2 at 12 and number 3 at 14
    List<LectureDao> topic1 = Arrays.asList(
            new LectureDao(1L, 1L, 0),
            new LectureDao(2L, 1L, 0),
            new LectureDao(3L, 1L, 0)
    );

    List<LectureDao> topic2 = Arrays.asList(
            new LectureDao(1L, 2L, 0),
            new LectureDao(2L, 2L, 0),
            new LectureDao(3L, 2L, 0)
    );

    List<LectureDao> topic3 = Arrays.asList(
            new LectureDao(1L, 3L, 0),
            new LectureDao(2L, 3L, 0),
            new LectureDao(3L, 3L, 0)
    );


    public void signUpForLecture(Long topicNumber, Long lectureNumber) {
        User loggedUser = userRepository.findUserByUsername(userSession.getUsername());
        Lecture lectureToAdd = new Lecture();


        for (Lecture lecture : loggedUser.getAttendedLectures()) {
            if (lecture.getLectureNumber().equals(lectureNumber))
                throw new UserAlreadyAttendsException("User already attends lecture at this time");
            if (lecture.getLectureNumber().equals(lectureNumber) && lecture.getTopicNumber().equals(topicNumber))
                throw new UserAlreadyAttendsThisLecture("User already attends this lecture");

        }

        //we check what topic user wants to attend and then get specific lecture, create Lecture object that can be send to DB
        switch (topicNumber.intValue()) {
            case 1:

                LectureDao lecture1 = topic1.get(lectureNumber.intValue() - 1);
                lectureToAdd.setLectureNumber(lecture1.getLectureNumber());
                lectureToAdd.setTopicNumber(lecture1.getTopicNumber());
                lectureToAdd.setAppUserId(loggedUser.getId());
                if (lecture1.getNumberOfAttendees() >= 5)
                    throw new NotEnoughSeatsException("Lecture is full");
                lectureToAdd.setNumberOfAttendees(lecture1.getNumberOfAttendees() + 1);
                lecture1.setNumberOfAttendees(lectureToAdd.getNumberOfAttendees());
                sendEmailConfirmation(lectureToAdd.toString(loggedUser.getUsername(), loggedUser.getEmail()));
                loggedUser.addLecture(lectureToAdd);
                System.out.println("You have singed up for a lecture");
                userRepository.save(loggedUser);
                break;
            case 2:
                LectureDao lecture2 = topic2.get(lectureNumber.intValue() - 1);
                lectureToAdd.setLectureNumber(lecture2.getLectureNumber());
                lectureToAdd.setTopicNumber(lecture2.getTopicNumber());
                lectureToAdd.setAppUserId(loggedUser.getId());
                if (lecture2.getNumberOfAttendees() >= 5)
                    throw new NotEnoughSeatsException("Lecture is full");
                lectureToAdd.setNumberOfAttendees(lecture2.getNumberOfAttendees() + 1);
                sendEmailConfirmation(lectureToAdd.toString(loggedUser.getUsername(), loggedUser.getEmail()));
                lecture2.setNumberOfAttendees(lectureToAdd.getNumberOfAttendees());
                loggedUser.addLecture(lectureToAdd);
                System.out.println("You have singed up for a lecture");
                userRepository.save(loggedUser);
                break;
            case 3:
                LectureDao lecture3 = topic3.get(lectureNumber.intValue() - 1);
                lectureToAdd.setLectureNumber(lecture3.getLectureNumber());
                lectureToAdd.setTopicNumber(lecture3.getTopicNumber());
                lectureToAdd.setAppUserId(loggedUser.getId());
                if (lecture3.getNumberOfAttendees() >= 5)
                    throw new NotEnoughSeatsException("Lecture is full");
                lectureToAdd.setNumberOfAttendees(lecture3.getNumberOfAttendees() + 1);
                sendEmailConfirmation(lectureToAdd.toString(loggedUser.getUsername(), loggedUser.getEmail()));
                lecture3.setNumberOfAttendees(lectureToAdd.getNumberOfAttendees());
                loggedUser.addLecture(lectureToAdd);
                System.out.println("You have singed up for a lecture");
                userRepository.save(loggedUser);
                break;

        }

    }


    public List<LectureDao> getListOfLectures() {
        List<LectureDao> returnList = new ArrayList<>();

        returnList.addAll(topic1);
        returnList.addAll(topic2);
        returnList.addAll(topic3);

        return returnList;
    }

    public List<LectureDao> getListOfUsersLectures() {
        if (!userSession.isLoggedIn())
            throw new UserNotLoggedException("User is not logged in");
        User loggedUser = userRepository.findUserByUsername(userSession.getUsername());
        List<LectureDao> returnList = new ArrayList<>();

        for (Lecture lecture : loggedUser.getAttendedLectures()) {
            returnList.add(new LectureDao(lecture.getLectureNumber(), lecture.getTopicNumber(), lecture.getNumberOfAttendees()));
        }

        return returnList;
    }


    private void sendEmailConfirmation(String lecture) {

        try {
            //create file to save email to
            FileWriter output
                    = new FileWriter("emails.txt", true);
            output.write(lecture);
            output.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public void cancelLecture(Long lectureNumber) {
        //we get logged user
        User loggedUser = userRepository.findUserByUsername(userSession.getUsername());

        //check if user attends lecture that we specify in URL and save it to list
        List<Lecture> lecturesToRemove = loggedUser.getAttendedLectures()
                .stream()
                .filter(lecture -> lecture.getLectureNumber().equals(lectureNumber))
                .collect(Collectors.toList());

        //if user attends lecture, it will be saved to list, because system prevents attending
        //more than one lecture at the same time, the list can be either empty or have one element
        if (lecturesToRemove.size() == 0)
            throw new UserDoesntAttendAnyLecture("You don't attend any lecture");

        loggedUser.getAttendedLectures().remove(lecturesToRemove.get(0));


        userRepository.save(loggedUser);
    }
}
