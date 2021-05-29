package pl.staz.ItConf.model.dto;

import javax.persistence.Column;

public class LectureDto {

    private Long lectureId;
    private int topicNumber;
    private Long appUserId;

    public LectureDto(Long lectureId, int topicNumber, Long appUserId) {
        this.lectureId = lectureId;
        this.topicNumber = topicNumber;
        this.appUserId = appUserId;
    }

    public Long getLectureId() {
        return lectureId;
    }

    public int getTopicNumber() {
        return topicNumber;
    }

    public Long getAppUserId() {
        return appUserId;
    }
}
