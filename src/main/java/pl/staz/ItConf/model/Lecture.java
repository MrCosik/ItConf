package pl.staz.ItConf.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "lecture")
public class Lecture {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "lecture_number")
    private Long lectureNumber;
    @Column(name = "topic_number")
    private Long topicNumber;
    @Column(name = "app_user_id")
    private Long appUserId;
    @Column(name = "attendees")
    private int numberOfAttendees;


    public Lecture() {
    }

    public Lecture(Long topicNumber, Long appUserId) {
        this.topicNumber = topicNumber;
        this.appUserId = appUserId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLectureNumber() {
        return lectureNumber;
    }

    public void setLectureNumber(Long lectureId) {
        this.lectureNumber = lectureId;
    }

    public Long getTopicNumber() {
        return topicNumber;
    }

    public void setTopicNumber(Long topicNumber) {
        this.topicNumber = topicNumber;
    }

    public Long getAppUserId() {
        return appUserId;
    }

    public void setAppUserId(Long appUserId) {
        this.appUserId = appUserId;
    }

    public int getNumberOfAttendees() {
        return numberOfAttendees;
    }

    public void setNumberOfAttendees(int attendees) {
        this.numberOfAttendees = attendees;
    }

    public String toString( String username, String email) {
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
//        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.now();

        String startHour = "00:00";
        String endHour = "1:45";

        switch (lectureNumber.intValue()){
            case 1:
                startHour = "10:00";
                endHour = "11:45";
                break;
            case 2:
                startHour = "12:00";
                endHour = "13:45";
                break;
            case 3:
                startHour = "14:00";
                endHour = "15:45";
                break;

        }

        return "To: " + email +" <"+username+">\n"+
                "From: DefinitelyNotABot@TheGreatestITCompany.com"+
                "You have signed for lecture nr: " + lectureNumber + ", ont topic nr: " + topicNumber+".\n" +
                "The lecture starts at: " + startHour + " and ends at: " + endHour +".\n"+
                "Message send at: "+ dtf1.format(zonedDateTime) +"\n";
    }
}
