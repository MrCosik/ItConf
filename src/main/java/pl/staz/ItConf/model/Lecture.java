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
    private Long lectureId;
    @Column(name = "topic_number")
    private int topicNumber;
    @Column(name = "app_user_id")
    private Long appUserId;


    public Lecture() {
    }

    public Lecture(Long lectureId, int topicNumber, Long appUserId) {
        this.lectureId = lectureId;
        this.topicNumber = topicNumber;
        this.appUserId = appUserId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLectureId() {
        return lectureId;
    }

    public void setLectureId(Long lectureId) {
        this.lectureId = lectureId;
    }

    public int getTopicNumber() {
        return topicNumber;
    }

    public void setTopicNumber(int topicNumber) {
        this.topicNumber = topicNumber;
    }

    public Long getAppUserId() {
        return appUserId;
    }

    public void setAppUserId(Long appUserId) {
        this.appUserId = appUserId;
    }
}
