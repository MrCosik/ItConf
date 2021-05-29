package pl.staz.ItConf.model;

import javax.xml.crypto.Data;

public class TopicsLecture {


    private Long topicId;
    private Long lectureNumber;
    private int numberOfAttendees;

    public TopicsLecture(Long topicId, Long lectureNumber, int numberOfAttendees) {
        this.topicId = topicId;
        this.lectureNumber = lectureNumber;
        this.numberOfAttendees = numberOfAttendees;
    }

    public Long getTopicId() {
        return topicId;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

    public Long getLectureNumber() {
        return lectureNumber;
    }

    public void setLectureNumber(Long lectureNumber) {
        this.lectureNumber = lectureNumber;
    }

    public int getNumberOfAttendees() {
        return numberOfAttendees;
    }

    public void setNumberOfAttendees(int numberOfAttendees) {
        this.numberOfAttendees = numberOfAttendees;
    }
}
