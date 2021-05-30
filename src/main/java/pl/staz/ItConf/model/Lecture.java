package pl.staz.ItConf.model;

import javax.persistence.*;

@Entity
@Table(name = "lecture")
public class Lecture {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "lecture_id")
    private Long lectureNumber;
    @Column(name = "topic_number")
    private Long topicNumber;
    @Column(name = "app_user_id")
    private Long appUserId;
    @Column(name = "attendees")
    private int attendees;


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

    public int getAttendees() {
        return attendees;
    }

    public void setAttendees(int attendees) {
        this.attendees = attendees;
    }

    @Override
    public String toString() {
        return "Lecture: " + lectureNumber + " of topic nr: " + topicNumber;
    }
}
